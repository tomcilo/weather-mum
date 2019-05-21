import java.io.File;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

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
	
	public Weather() {
	
	}

    public Weather(Clothing recommendation, String dateString, String description,
                   float realFeel, float high, float low, float overall) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH").parse(dateString);


	    this.recommendation = recommendation;
        this.weekDay = StyleGuide.getDateFormat().format(date);
        this.date = date;
        this.hour = Integer.parseInt(StyleGuide.getHourFormat().format(date));
        this.description = description;
        this.realFeel = realFeel;
        this.high = high;
        this.low = low;
        this.overall = overall;
    }

    public Weather(Map<String, String> map) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH").parse(map.get("date"));


        this.recommendation = Recommender.recommend(map);
        this.weekDay = StyleGuide.getDateFormat().format(date);
        this.date = date;
        this.hour = Integer.parseInt(StyleGuide.getHourFormat().format(date));
        this.description = map.get("WeatherText");
        this.realFeel = Float.parseFloat(map.get("RealFeelTemperature"));
        this.high = Float.parseFloat(map.get("RealFeelTemperatureHigh"));
        this.low = Float.parseFloat(map.get("RealFeelTemperatureLow"));
        this.overall = Float.parseFloat(map.get("Temperature"));
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
