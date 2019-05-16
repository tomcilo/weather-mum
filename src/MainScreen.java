import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class MainScreen extends JFrame {
    private City city;

    public MainScreen(City city) throws IOException {
        super(city.getDisplayName());
        this.city = city;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(StyleGuide.getScreenWidth(), StyleGuide.getScreenHeight());

        add(currentWeather(), BorderLayout.NORTH);


    }

    private JPanel currentWeather() throws IOException {
        JPanel weath =  new JPanel();
        weath.setLayout(new GridLayout(1,2));
        weath.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel left = new JPanel();
        left.setLayout(new GridLayout(3,1));
        JPanel right = new JPanel();
        right.setLayout(new GridLayout(2,1));

        // creating left side of top of screen
        // large label for temp
        JLabel tempText = new JLabel(city.getCurrent().getOverall() + "°");
        tempText.setFont(StyleGuide.getLargeFont());
        left.add(tempText);
        // weather description
        JLabel descText = new JLabel(city.getCurrent().getDescription());
        descText.setFont(StyleGuide.getRegularFont());
        left.add(descText);
        // high low
        JLabel hlText = new JLabel(city.getCurrent().getHighLow());
        hlText.setFont(StyleGuide.getSmallFont());
        left.add(hlText);

        weath.add(left);


        // creating right side of top of screen
        // location icon
        BufferedImage locIcon = ImageIO.read(StyleGuide.getLocationIcon());
        JLabel locIconLabel = new JLabel(new ImageIcon(locIcon));
        right.add(locIconLabel, BorderLayout.EAST);

        // weather icon
        BufferedImage weathIconTmp = ImageIO.read(city.getCurrent().getWeatheryIcon());
        Image weathIcon = weathIconTmp.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        JLabel weathIconLabel = new JLabel(new ImageIcon(weathIcon));
        right.add(weathIconLabel);

        weath.add(right);

        return weath;
    }

    public static void main(String[] args) throws java.io.IOException {
        Weather w = new Weather(StyleGuide.getSunnyIcon(), StyleGuide.getSunnyIcon(),
                new Clothing(StyleGuide.getUmbrellaIcon(), StyleGuide.gettShirtIcon(),
                        StyleGuide.getShortsIcon(), StyleGuide.getShortsIcon()),
                "Monday", new Date(), 10, "Sunny", 18, 20, 10, 20);
        ArrayList we = new ArrayList<Weather>();
        we.add(w);


        City c = new City("Test", we, we, w, 20, 10);
        MainScreen gui = new MainScreen(c);
        gui.setVisible(true);
    }



}
