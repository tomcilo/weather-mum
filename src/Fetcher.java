import java.util.*;
import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.stream.Collectors;

/* TODO:
 *   Add some state and cashe responses
 *   Add forecast
 *   Return Weather, City and Clothing classes instead
 *
 */

public class Fetcher {
	// self explanatory
	private static final String api_key = "sAITtV5AClfBKltmGkAVbufG0IAxFsue";
	// %d location code
	// %s api_key
	private static final String current_api = "http://dataservice.accuweather.com/currentconditions/v1/%d?apikey=%s";
	// %s api_key
	// %s quary (prefix)
	private static final String autocomplete_api = "http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey=%s&q=%s&language=en-uk";
	// %s api_key
	// %s ip address
	private static final String current_city_api = "http://dataservice.accuweather.com/locations/v1/cities/ipaddress?apikey=%s&q=%s&language=en-uk&details=true";
	// %d location code
	// %s api_key
	private static final String forecast_api = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/%d?apikey=%s&details=true&metric=true";

	
	private static String __get(JSONObject obj, String a, String b) {
		JSONObject A = (JSONObject)obj.get(a);

		return A.get(b).toString();
	}
	private static String __get(JSONObject obj, String a, String b, String c) {
		JSONObject A = (JSONObject)obj.get(a);
		JSONObject B = (JSONObject)A.get(b);

		return B.get(c).toString();
	}




	// Returns raw response given url
	private static String download(String url) throws MalformedURLException, IOException {
		URL the_url = new URL(url);
		BufferedReader bf = new BufferedReader(new InputStreamReader(the_url.openStream()));

		return bf.lines().collect(Collectors.joining());
	}

	// TODO: documentation
	public static Map<String, String> fetchCurrent(int location_code) throws Exception {
		String response = download(String.format(current_api, location_code, api_key));
		

		JSONArray ja = (JSONArray)(new JSONParser().parse(response));
		JSONObject obj = (JSONObject)ja.get(0);
		
		JSONObject temp = (JSONObject)obj.get("Temperature");
		JSONObject metric = (JSONObject)temp.get("Metric");
		
		// Return parameters
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("Temperature", metric.get("Value").toString());
		ret.put("WeatherText", obj.get("WeatherText").toString());
		ret.put("WeatherIcon", obj.get("WeatherIcon").toString());



		return ret;
		//return response;
	}

	// TODO: documentation
	public static List<Integer> fetchAutocompletedCities(String prefix) throws Exception {
		String response = download(String.format(autocomplete_api, api_key, prefix));
	

		JSONArray ja = (JSONArray)(new JSONParser().parse(response));
		
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < ja.size(); i++) {
			JSONObject obj = (JSONObject)ja.get(i);
			JSONObject js_country = (JSONObject)obj.get("Country");
			JSONObject js_area = (JSONObject)obj.get("AdministrativeArea");

			// might be useful
			String name    = obj.get("LocalizedName").toString();
			String code    = obj.get("Key").toString();
			String country = js_country.get("LocalizedName").toString();
			String area    = js_area.get("ID").toString();

			ret.add(Integer.parseInt(code));
			
		}

		return ret;
	}
	
	public static Integer fetchCurrentCity() throws Exception {
		String ipaddr = download("https://ipinfo.io/ip");
		String response = download(String.format(current_city_api, api_key, ipaddr));
	
		JSONObject obj = (JSONObject)(new JSONParser().parse(response));
		
		// might be useful
		String name = obj.get("LocalizedName").toString();
		String code = obj.get("Key").toString();
	
		
		return Integer.parseInt(code);
	}

	public static List<Map<String, String>> fetchForecast(int location_code) throws Exception {
		String response = download(String.format(forecast_api, location_code, api_key));
	
		List<Map<String, String>> ret = new ArrayList<Map<String, String>>();

		JSONObject obj = (JSONObject)(new JSONParser().parse(response));
		JSONArray arr = (JSONArray)obj.get("DailyForecasts");

		for (int i = 0; i < arr.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();

			JSONObject js_map = (JSONObject)arr.get(i);
		
			// TODO: add the rest
			map.put("RealFeelMin", __get(js_map, "RealFeelTemperature", "Minimum", "Value").toString());

			
			ret.add(map);
		}

		return ret;
	}

	// Only for testing
	public static void main(String[] args) throws Exception {
		System.out.printf("fetchCurrent(327200 -- Cambridge):\n   %s\n", fetchCurrent(327200));

		System.out.printf("\n\n\nfetchAutocompletedCities(\"bel\")\n   %s\n", fetchAutocompletedCities("beg"));
	
		System.out.printf("\n\n\nfetchCurretnCity()\n   %s\n", fetchCurrentCity());

		System.out.printf("\n\n\nfetchForecast(32700 -- Cambridge):\n   %s", fetchForecast(327200));
	}
}
