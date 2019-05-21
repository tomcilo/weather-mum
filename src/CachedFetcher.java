import java.util.*;
import java.util.stream.*;

/* TODO:
 *   add some sort of timestamp
 *   in order to 
 *
 */

public class CachedFetcher {
	// maps location code to the map of attributes of the corresponding cities
	//     name
	//
	private static Map<Integer, String> citynames = new HashMap<Integer, String>();
	private static Map<Integer, List<Weather>> hourly = new HashMap<Integer, List<Weather>>();
	private static Map<Integer, List<Weather>> daily = new HashMap<Integer, List<Weather>>();
	private static Map<Integer, Weather> current = new HashMap<Integer, Weather>();

	// due to backwards compability, this isn't in Fetcher
	private static Weather createWeather(Date date, int hour, String description, float realFeel, float high, float low, float overall) {
		return new Weather();
	}
	private static Weather createWeather(Map<String, String> map) {
//		new Weather(Recommender.recommend(m), )
		return new Weather();
	}

	public static String getDisplayName(int code) {
		try {
			if (citynames.get(code) == null)
				citynames.put(code, Fetcher.fetchCityName(code));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.printf("there was an error, too bad (CachedFetcher::getDisplayName)\n");
		}
		return citynames.get(code);
	}
	// this is hourly weather
	public static List<Weather> getDaily(int code) {
		try {
			if (hourly.get(code) == null)
				hourly.put(code, Fetcher.fetchHourlyForecast(code).stream().map(x -> createWeather(x)).collect(Collectors.toList()));
		}
		catch (Exception e) {
			System.out.printf("there was an error, too bad (CachedFetcher::getDaily)\n");
		}
		return new ArrayList<Weather>(hourly.get(code));
	}
	public static List<Weather> getWeekly(int code) {
		try {
			if (daily.get(code) == null)
				daily.put(code, Fetcher.fetchForecast(code).stream().map(x -> createWeather(x)).collect(Collectors.toList()));
		}
		catch (Exception e) {
			System.out.printf("there was an error, too bad (CachedFetcher::getWeekly)\n");
		}
		return new ArrayList<Weather>(daily.get(code));
	}
	public static Weather getCurrent(int code) {
		try {
			if (current.get(code) == null)
				current.put(code, createWeather(Fetcher.fetchCurrent(code)));
		}
		catch (Exception e) {
			System.out.printf("there was an error, too bad (CachedFetcher::getCurrent)\n");
		}
		return current.get(code);
	}
	public static int getYesterdayHigh(int code) {
		return -1; // asdfsadf
	}
	public static int getYesterdayLow(int code) {
		return -1; // asdfasdf
	}

	public static void main(String[] args) {
		System.out.printf("name(%d) = %s\n    expected Cambridge", 327200, getDisplayName(327200));
		System.out.printf("name(%d) = %s\n    expected Cambridge", 327200, getDisplayName(327200));
		System.out.printf("name(%d) = %s\n    expected Cambridge", 327200, getDisplayName(327200));
		System.out.printf("name(%d) = %s\n    expected Cambridge", 327200, getDisplayName(327200));
	}
	
}
