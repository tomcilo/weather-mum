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
        add(currentOutfit(), BorderLayout.CENTER);
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
        BufferedImage locIconTmp = ImageIO.read(StyleGuide.getLocationIcon());
        Image locIconTmp2 = locIconTmp.getScaledInstance(20,20,Image.SCALE_SMOOTH);
        Icon locIcon = new ImageIcon(locIconTmp2);
        JButton locationButton = new JButton();
        locationButton.setIcon(locIcon);
        locationButton.setText(city.getDisplayName());
        locationButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        locationButton.setFont(StyleGuide.getLargeFont());
        right.add(locationButton);

        // weather icon
        BufferedImage weathIconTmp = ImageIO.read(city.getCurrent().getWeatheryIcon());
        Image weathIcon = weathIconTmp.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        JLabel weathIconLabel = new JLabel(new ImageIcon(weathIcon));
        right.add(weathIconLabel);

        weath.add(right);

        return weath;
    }

    private JPanel currentOutfit() throws IOException {
        JPanel outfit =  new JPanel();
        outfit.setLayout(new GridLayout(4,1));

        BufferedImage accessoryIconTmp = ImageIO.read(city.getCurrent().getRecommendation().getAccesoriesIcon());
        Image accessoryIcon = accessoryIconTmp.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel accessoryIconLabel = new JLabel(new ImageIcon(accessoryIcon));
        outfit.add(accessoryIconLabel);

        BufferedImage topIconTmp = ImageIO.read(city.getCurrent().getRecommendation().getTopIcon());
        Image topIcon = topIconTmp.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel topIconLabel = new JLabel(new ImageIcon(topIcon));
        outfit.add(topIconLabel);

        BufferedImage bottomIconTmp = ImageIO.read(city.getCurrent().getRecommendation().getBottomIcon());
        Image bottomIcon = bottomIconTmp.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel bottomIconLabel = new JLabel(new ImageIcon(bottomIcon));
        outfit.add(bottomIconLabel);

        BufferedImage shoesIconTmp = ImageIO.read(city.getCurrent().getRecommendation().getShoesIcon());
        Image shoesIcon = shoesIconTmp.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel shoesIconLabel = new JLabel(new ImageIcon(shoesIcon));
        outfit.add(shoesIconLabel);

        return outfit;
    }

    public static void main(String[] args) throws java.io.IOException {
        Weather w = new Weather(StyleGuide.getSunnyIcon(), StyleGuide.getSunnyIcon(),
                new Clothing(StyleGuide.getUmbrellaIcon(), StyleGuide.gettShirtIcon(),
                        StyleGuide.getShortShortsIcon(), StyleGuide.getSearchIcon()),
                "Monday", new Date(), 10, "Sunny", 18, 20, 10, 20);
        ArrayList we = new ArrayList<Weather>();
        we.add(w);


        City c = new City("Test", we, we, w, 20, 10);
        MainScreen gui = new MainScreen(c);
        gui.setVisible(true);
    }



}
