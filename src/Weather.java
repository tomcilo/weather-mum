import java.io.File;
import java.nio.file.Path;
import java.util.Date;

public class Weather {
    private Clothing recommendation;
    private String weekDay;
    private Date date;
    private int hour;
    private String description;
    private float realFeel;
    private float high;
    private float low;
    private float overall;

    public Weather(Clothing recommendation,
                   String weekDay, Date date, int hour, String description,
                   float realFeel, float high, float low, float overall) {
        this.recommendation = recommendation;
        this.weekDay = weekDay;
        this.date = date;
        this.hour = hour;
        this.description = description;
        this.realFeel = realFeel;
        this.high = high;
        this.low = low;
        this.overall = overall;
    }

    public Clothing getRecommendation() {
        return recommendation;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public Date getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public String getDescription() {
        return description;
    }

    public float getRealFeel() {
        return realFeel;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public float getOverall() {
        return overall;
    }

    public String getHighLow() { return Math.round(low)+ "°/" + Math.round(high) + "°"; }
}
