import java.util.*;
import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.stream.Collectors;

/* TODO:
 *   Add some state and cashe responses
 *   
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

	// Returns raw response given url
	private static String download(String url) throws MalformedURLException, IOException {
		URL the_url = new URL(url);
		BufferedReader bf = new BufferedReader(new InputStreamReader(the_url.openStream()));

		return bf.lines().collect(Collectors.joining());
	}

	// TODO: documentation
	public static Map<String, String> fetchCurrent(int location_code) throws Exception {
//		String response = download(String.format(current_api, location_code, api_key));
		String response = "[{\"LocalObservationDateTime\":\"2019-05-14T14:22:00+01:00\",\"EpochTime\":1557840120,\"WeatherText\":\"Sunny\",\"WeatherIcon\":1,\"HasPrecipitation\":false,\"PrecipitationType\":null,\"IsDayTime\":true,\"Temperature\":{\"Metric\":{\"Value\":18.9,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":66.0,\"Unit\":\"F\",\"UnitType\":18}},\"MobileLink\":\"http://m.accuweather.com/en/gb/cambridge/gl2-7/current-weather/327200?lang=en-us\",\"Link\":\"http://www.accuweather.com/en/gb/cambridge/gl2-7/current-weather/327200?lang=en-us\"}]";
		

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
//		String response = download(String.format(autocomplete_api, api_key, prefix));
		String response = "[{\"Version\":1,\"Key\":\"298198\",\"Type\":\"City\",\"Rank\":20,\"LocalizedName\":\"Belgrade\",\"Country\":{\"ID\":\"RS\",\"LocalizedName\":\"Serbia\"},\"AdministrativeArea\":{\"ID\":\"00\",\"LocalizedName\":\"Belgrade\"}},{\"Version\":1,\"Key\":\"44403\",\"Type\":\"City\",\"Rank\":21,\"LocalizedName\":\"Belo Horizonte\",\"Country\":{\"ID\":\"BR\",\"LocalizedName\":\"Brazil\"},\"AdministrativeArea\":{\"ID\":\"MG\",\"LocalizedName\":\"Minas Gerais\"}},{\"Version\":1,\"Key\":\"326934\",\"Type\":\"City\",\"Rank\":30,\"LocalizedName\":\"Belfast\",\"Country\":{\"ID\":\"GB\",\"LocalizedName\":\"United Kingdom\"},\"AdministrativeArea\":{\"ID\":\"BFS\",\"LocalizedName\":\"Belfast\"}},{\"Version\":1,\"Key\":\"292195\",\"Type\":\"City\",\"Rank\":31,\"LocalizedName\":\"Belgorod\",\"Country\":{\"ID\":\"RU\",\"LocalizedName\":\"Russia\"},\"AdministrativeArea\":{\"ID\":\"BEL\",\"LocalizedName\":\"Belgorod\"}},{\"Version\":1,\"Key\":\"35570\",\"Type\":\"City\",\"Rank\":35,\"LocalizedName\":\"Belford Roxo\",\"Country\":{\"ID\":\"BR\",\"LocalizedName\":\"Brazil\"},\"AdministrativeArea\":{\"ID\":\"RJ\",\"LocalizedName\":\"Rio De Janeiro\"}},{\"Version\":1,\"Key\":\"101856\",\"Type\":\"City\",\"Rank\":35,\"LocalizedName\":\"Bello\",\"Country\":{\"ID\":\"CO\",\"LocalizedName\":\"Colombia\"},\"AdministrativeArea\":{\"ID\":\"ANT\",\"LocalizedName\":\"Antioquia\"}},{\"Version\":1,\"Key\":\"188752\",\"Type\":\"City\",\"Rank\":35,\"LocalizedName\":\"Belgaum\",\"Country\":{\"ID\":\"IN\",\"LocalizedName\":\"India\"},\"AdministrativeArea\":{\"ID\":\"KA\",\"LocalizedName\":\"Karnataka\"}},{\"Version\":1,\"Key\":\"188759\",\"Type\":\"City\",\"Rank\":35,\"LocalizedName\":\"Bellary\",\"Country\":{\"ID\":\"IN\",\"LocalizedName\":\"India\"},\"AdministrativeArea\":{\"ID\":\"KA\",\"LocalizedName\":\"Karnataka\"}},{\"Version\":1,\"Key\":\"44857\",\"Type\":\"City\",\"Rank\":41,\"LocalizedName\":\"Belém\",\"Country\":{\"ID\":\"BR\",\"LocalizedName\":\"Brazil\"},\"AdministrativeArea\":{\"ID\":\"PA\",\"LocalizedName\":\"Pará\"}},{\"Version\":1,\"Key\":\"301229\",\"Type\":\"City\",\"Rank\":42,\"LocalizedName\":\"Bellville\",\"Country\":{\"ID\":\"ZA\",\"LocalizedName\":\"South Africa\"},\"AdministrativeArea\":{\"ID\":\"WC\",\"LocalizedName\":\"Western Cape\"}}]";
	
		
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
//		String ipaddr = download("https://ipinfo.io/ip");
		String ipaddr = "131.111.5.3";
//		String response = download(String.format(current_city_api, api_key, ipaddr));
		String response = "{\"Version\":1,\"Key\":\"327200\",\"Type\":\"City\",\"Rank\":85,\"LocalizedName\":\"Cambridge\",\"EnglishName\":\"Cambridge\",\"PrimaryPostalCode\":\"GL2 7\",\"Region\":{\"ID\":\"EUR\",\"LocalizedName\":\"Europe\",\"EnglishName\":\"Europe\"},\"Country\":{\"ID\":\"GB\",\"LocalizedName\":\"United Kingdom\",\"EnglishName\":\"United Kingdom\"},\"AdministrativeArea\":{\"ID\":\"GLS\",\"LocalizedName\":\"Gloucestershire\",\"EnglishName\":\"Gloucestershire\",\"Level\":1,\"LocalizedType\":\"Non-Metropolitan County\",\"EnglishType\":\"Non-Metropolitan County\",\"CountryID\":\"GB\"},\"TimeZone\":{\"Code\":\"BST\",\"Name\":\"Europe/London\",\"GmtOffset\":1.0,\"IsDaylightSaving\":true,\"NextOffsetChange\":\"2019-10-27T01:00:00Z\"},\"GeoPosition\":{\"Latitude\":51.731,\"Longitude\":-2.364,\"Elevation\":{\"Metric\":{\"Value\":40.0,\"Unit\":\"m\",\"UnitType\":5},\"Imperial\":{\"Value\":131.0,\"Unit\":\"ft\",\"UnitType\":0}}},\"IsAlias\":false,\"SupplementalAdminAreas\":[{\"Level\":0,\"LocalizedName\":\"England\",\"EnglishName\":\"England\"},{\"Level\":2,\"LocalizedName\":\"Stroud\",\"EnglishName\":\"Stroud\"}],\"DataSets\":[\"Alerts\",\"MinuteCast\",\"Radar\"],\"Details\":{\"Key\":\"327200\",\"StationCode\":\"EGGL\",\"StationGmtOffset\":0.0,\"BandMap\":\"ENGL\",\"Climo\":\"EGGD\",\"LocalRadar\":\"\",\"MediaRegion\":null,\"Metar\":\"EGBJ\",\"NXMetro\":\"\",\"NXState\":\"EUR3\",\"Population\":null,\"PrimaryWarningCountyCode\":\"\",\"PrimaryWarningZoneCode\":\"\",\"Satellite\":\"EUR3\",\"Synoptic\":\"03628\",\"MarineStation\":\"\",\"MarineStationGMTOffset\":null,\"VideoCode\":\"\",\"LocationStem\":\"gb/cambridge/gl2-7\",\"PartnerID\":null,\"Sources\":[{\"DataType\":\"Alerts\",\"Source\":\"Met Office National Severe Weather Warnings\",\"SourceId\":4},{\"DataType\":\"Alerts\",\"Source\":\"UK Environment Agency\",\"SourceId\":42},{\"DataType\":\"CurrentConditions\",\"Source\":\"AccuWeather\",\"SourceId\":1},{\"DataType\":\"DailyForecast\",\"Source\":\"AccuWeather\",\"SourceId\":1},{\"DataType\":\"HourlyForecast\",\"Source\":\"AccuWeather\",\"SourceId\":1},{\"DataType\":\"MinuteCast\",\"Source\":\"AccuWeather\",\"SourceId\":1},{\"DataType\":\"Radar\",\"Source\":\"UK Met Office\",\"SourceId\":60},{\"DataType\":\"Severe Weather Push Notifications\",\"Source\":\"Met Office National Severe Weather Warnings\",\"SourceId\":4},{\"DataType\":\"Severe Weather Push Notifications\",\"Source\":\"UK Environment Agency\",\"SourceId\":42}],\"CanonicalPostalCode\":\"GL2 7\",\"CanonicalLocationKey\":\"327200\"}}";
	
		JSONObject obj = (JSONObject)(new JSONParser().parse(response));
		
		// might be useful
		String name = obj.get("LocalizedName").toString();
		String code = obj.get("Key").toString();

		return Integer.parseInt(code);
	}

	// Only for testing
	public static void main(String[] args) throws Exception {
		System.out.printf("fetchCurrent(327200 -- Cambridge):\n   %s\n", fetchCurrent(327200));

		System.out.printf("\n\n\nfetchAutocompletedCities(\"bel\")\n   %s\n", fetchAutocompletedCities("beg"));
	
		System.out.printf("\n\n\nfetchCurretnCity()\n   %s\n", fetchCurrentCity());
	}
}
