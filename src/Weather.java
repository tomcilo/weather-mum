import java.io.File;
import java.nio.file.Path;
import java.util.Date;

public class Weather {
    private File weatheryIcon;
    private File mainIcon;
    private Clothing recommendation;
    private String weekDay;
    private Date date;
    private int hour;
    private String description;
    private int realFeel;
    private int high;
    private int low;
    private int overall;

    public Weather(File weatheryIcon, File clotheryIcon, Clothing recommendation,
                   String weekDay, Date date, int hour, String description,
                   int realFeel, int high, int low, int overall) {
        this.weatheryIcon = weatheryIcon;
        this.mainIcon = clotheryIcon;
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

    public File getWeatheryIcon() {
        return weatheryIcon;
    }

    public File getMainIcon() {
        return mainIcon;
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

    public int getRealFeel() {
        return realFeel;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public int getOverall() {
        return overall;
    }

    public String getHighLow() { return low + "°/" + high + "°"; }
}