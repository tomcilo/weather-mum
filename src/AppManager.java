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
    private JPanel currentPanel;

    public AppManager() throws IOException {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(StyleGuide.getScreenWidth(), StyleGuide.getScreenHeight());

        mainFrame.setLayout(new GridLayout(1, 1));

        /*
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
        */

        cityListScreen = new CityListScreen(this);
        mainFrame.add(cityListScreen);
        currentPanel = cityListScreen;
        searchScreen = new SearchScreen(this);
        mainFrame.setVisible(true);
    }

    public void goToCityListScreen() {
        System.out.println("I'll go to the CityListScreen");
    }


    public void searchScreenCitySelected(String cityName) {
        System.out.println(cityName + " was selected in the SearchScreen");
    }

    public void cityListScreenCitySelected(String cityName) {
        System.out.println(cityName + " was selected in the CityListScreen");
    }

    public void goToSearchScreen() {
        System.out.println("I'll go to the SearchScreen");
        mainFrame.remove(cityListScreen);
        mainFrame.add(searchScreen);
        currentPanel = searchScreen;
        mainFrame.setVisible(true);
    }


    public static void main(String[] args) {
        try {
            AppManager appManager = new AppManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
