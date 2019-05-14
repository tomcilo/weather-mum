import java.util.ArrayList;
import java.util.List;

public class City {
    private String displayName;
    private List<Weather> daily;
    private List<Weather> weekly;
    private Weather current;
    private int yesterdayHigh;
    private int yesterdayLow;

    public City(String displayName, List<Weather> daily, List<Weather> weekly,
                Weather current, int yesterdayHigh, int yesterdayLow) {
        this.displayName = displayName;
        this.daily = daily;
        this.weekly = weekly;
        this.current = current;
        this.yesterdayHigh = yesterdayHigh;
        this.yesterdayLow = yesterdayLow;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<Weather> getDaily() {
        return new ArrayList<>(daily);
    }

    public List<Weather> getWeekly() {
        return new ArrayList<>(weekly);
    }

    public Weather getCurrent() {
        return current;
    }

    public int getYesterdayHigh() {
        return yesterdayHigh;
    }

    public int getYesterdayLow() {
        return yesterdayLow;
    }

}
