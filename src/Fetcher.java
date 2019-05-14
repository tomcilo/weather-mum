import java.util.*;
import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.stream.Collectors;

public class Fetcher {
	private static final String api_key = "sAITtV5AClfBKltmGkAVbufG0IAxFsue";

	// %d is location code
	// %s api_key
	private static final String current_api = "http://dataservice.accuweather.com/currentconditions/v1/%d?apikey=%s";

	private static String download(String url) throws MalformedURLException, IOException {
		URL the_url = new URL(url);
		BufferedReader bf = new BufferedReader(new InputStreamReader(the_url.openStream()));

		return bf.lines().collect(Collectors.joining());
	}
	
	// 
	public static String fetchCurrent(int location_code) throws Exception {
		String response = download(String.format(current_api, location_code, api_key));

		JSONArray ja = (JSONArray)(new JSONParser().parse(response));
		Map<String, Object> map = new HashMap<String, Object>();

		// This can probably be replaced with ~1 line of code, but hey...
		// Load the content of the ja[0] into map
		for (Iterator itr = ja.iterator(); itr.hasNext(); ) {
			Iterator<Map.Entry> itr1 = ((Map) itr.next()).entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				map.put(pair.getKey().toString(), pair.getValue());
			}
		}

		return response;
	}

	// Only for testing
	public static void main(String[] args) throws Exception {
	//	download("https://wttr.in/");
		System.out.println(fetchCurrent(327200));
	}
}
