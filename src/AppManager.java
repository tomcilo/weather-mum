import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AppManager {

    private CityListScreen cityListScreen;
    private SearchScreen searchScreen;
    private MainScreen mainScreen;
    private JFrame mainFrame;

    public AppManager() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(StyleGuide.getScreenWidth(), StyleGuide.getScreenHeight());

        //mainFrame.setVisible(true);

        cityListScreen = new CityListScreen();
        searchScreen = new SearchScreen();
    }


    public void setCityListScreenVisible() {
        //mainFrame.add(cityListScreen);
        //mainFrame.setVisible(true);
        cityListScreen.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        AppManager appManager = new AppManager();
        appManager.setCityListScreenVisible();

        /*
        Weather w = new Weather(StyleGuide.getSunnyIcon(), StyleGuide.getSunnyIcon(),
                new Clothing(StyleGuide.getUmbrellaIcon(), StyleGuide.gettShirtIcon(),
                        StyleGuide.getShortShortsIcon(), StyleGuide.getSearchIcon()),
                "Monday", new Date(), 10, "Sunny", 18, 20, 10, 20);
        ArrayList we = new ArrayList<Weather>();
        we.add(w);
        appManager.createMainScreen(new City("Test", we, we, w, 20, 10));
        */
    }
}
