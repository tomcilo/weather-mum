import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppManager {

    private CityListScreen cityListScreen;
    private SearchScreen searchScreen;
    private MainScreen mainScreen;
    private JFrame mainFrame;

    public AppManager() throws IOException {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(2*StyleGuide.getScreenWidth(), StyleGuide.getScreenHeight());

        mainFrame.setLayout(new GridLayout(1, 3));


        Map<String, String> f = new HashMap<>();
        f.put("Temperature", "17.8");
        f.put("WeatherText", "Cloudy");
        f.put("WeatherIcon", "7");
        Weather w = new Weather(
                Recommender.recommend(f),
                "Monday", new Date(), 10, f.get("WeatherText"),
                Float.parseFloat(f.get("Temperature")), 20, 10,
                Float.parseFloat(f.get("Temperature")));
        ArrayList we = new ArrayList<Weather>();
        we.add(w);
        City c = new City("Test", we, we, w, 20, 10);


        cityListScreen = new CityListScreen();
        mainFrame.add(cityListScreen);
        searchScreen = new SearchScreen();
        mainFrame.add(searchScreen);
        //mainScreen = new MainScreen(c);
        //mainFrame.add(mainScreen);
        mainFrame.setVisible(true);
    }

    //This is a very generic thing and it's bad but we'll improve on that
    public void notify(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) throws IOException {
        AppManager appManager = new AppManager();

    }
}
