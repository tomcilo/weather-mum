import java.util.ArrayList;
import java.util.List;

public class City {
	private int code;
    private String displayName;
    private List<Weather> daily;
    private List<Weather> weekly;
    private Weather current;
    private Integer yesterdayHigh;
    private Integer yesterdayLow;

    public City(String displayName, List<Weather> daily, List<Weather> weekly,
                Weather current, int yesterdayHigh, int yesterdayLow) {
        this.displayName = displayName;
        this.daily = daily;
        this.weekly = weekly;
        this.current = current;
        this.yesterdayHigh = yesterdayHigh;
        this.yesterdayLow = yesterdayLow;
    }
	public City(int code) {
		this.code = code;
	}

    public String getDisplayName() {
		if (displayName == null)
			displayName = CachedFetcher.getDisplayName(code);
		return displayName;
    }

    public List<Weather> getDaily() {
		if (daily == null)
			daily = new ArrayList<>(CachedFetcher.getDaily(code));
        return new ArrayList<>(daily);
    }

    public List<Weather> getWeekly() {
		if (weekly == null)
			weekly = new ArrayList<>(CachedFetcher.getWeekly(code));
        return new ArrayList<>(weekly);
    }

    public Weather getCurrent() {
		if (current == null)
			current = CachedFetcher.getCurrent(code);
        return current;
    }

    public int getYesterdayHigh() {
		if (yesterdayHigh == null)
			yesterdayHigh = CachedFetcher.getYesterdayHigh(code);
        return yesterdayHigh;
    }

    public int getYesterdayLow() {
		if (yesterdayLow == null)
			yesterdayLow = CachedFetcher.getYesterdayLow(code);
        return yesterdayLow;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }

}
