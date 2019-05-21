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
	static Map<Integer, Map<String, String>> city_store;
	public static String getDisplayName(int code) {
		// TODO: this should never happen now, but it might
		// break in the future
		return city_store.get(code).get("name");
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
