import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
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
        mainFrame = new JFrame("Weather Mum");
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

    private City createDummyCity(String cityName) throws ParseException {
        Weather w = new Weather(
                new Clothing(StyleGuide.getUmbrellaIcon(), StyleGuide.gettShirtIcon(),
                        StyleGuide.getShortsIcon(), StyleGuide.getSneakersIcon(), StyleGuide.getSunnyIcon(), StyleGuide.getSunnyIcon()),
                "2019-05-21T07:00:00+01:00", "Sunny", 18, 20, 10, 20);
        ArrayList we = new ArrayList<Weather>();
        we.add(w);


        City c = new City(cityName, we, we, w, 20, 10);
        return c;
    }

    private void goToScreen(JPanel dest) {
        mainFrame.remove(currentPanel);
        mainFrame.add(dest);
        currentPanel = dest;
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void goToCityListScreen() {
        System.out.println("I'll go to the CityListScreen");
        goToScreen(cityListScreen);
    }


    public void searchScreenCitySelected(City city) {
        System.out.println(city + " was selected in the SearchScreen");
        cityListScreen.addCityToList(city);
        goToScreen(cityListScreen);
    }

    public void cityListScreenCitySelected(City city) {
        System.out.println(city + " was selected in the CityListScreen");
        try {
            mainScreen = new MainScreen(city, this);
        } catch (Exception e) {
            System.out.println("Seems like there was an exception");
            e.printStackTrace();
            System.out.println("Not going there");
            return;
        }
        goToScreen(mainScreen);
    }

    public void goToSearchScreen() {
        System.out.println("I'll go to the SearchScreen");
        goToScreen(searchScreen);
    }


    public static void main(String[] args) {
        try {
            AppManager appManager = new AppManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
