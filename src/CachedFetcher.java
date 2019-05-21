import java.util.*;

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
	public static String getDisplayName(int code) {
		try {
			if (citynames.get(code) == null)
				citynames.put(code, Fetcher.fetchCityName(code));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.printf("there was an error, too bad\n");
		}
		return citynames.get(code);
	}
	public static List<Weather> getDaily(int code) {
		return new ArrayList<Weather>();
	}
	public static List<Weather> getWeekly(int code) {
		return new ArrayList<Weather>();
	}
	public static Weather getCurrent(int code) {
		return new Weather();
	}
	public static int getYesterdayHigh(int code) {
		return -1;
	}
	public static int getYesterdayLow(int code) {
		return -1;
	}

	public static void main(String[] args) {
		System.out.printf("name(%d) = %s\n    expected Cambridge", 327200, getDisplayName(327200));
		System.out.printf("name(%d) = %s\n    expected Cambridge", 327200, getDisplayName(327200));
		System.out.printf("name(%d) = %s\n    expected Cambridge", 327200, getDisplayName(327200));
		System.out.printf("name(%d) = %s\n    expected Cambridge", 327200, getDisplayName(327200));
	}
	
}
