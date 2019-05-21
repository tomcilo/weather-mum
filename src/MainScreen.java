import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainScreen extends JPanel {
    private City city;
    private int maxAccross = 5;

    private AppManager mainManager;

    public MainScreen(City city, AppManager mainManager) throws IOException {
        //super(city.getDisplayName());
        setLayout(new BorderLayout());
        this.city = city;
        this.mainManager = mainManager;

        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(StyleGuide.getScreenWidth(), StyleGuide.getScreenHeight());

        add(currentWeather(), BorderLayout.NORTH);
        add(currentOutfit(), BorderLayout.CENTER);
        add(futureWeather(), BorderLayout.SOUTH);
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
        JLabel tempText = new JLabel(city.getCurrent().getRealFeel() + "°");
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
        locationButton.addActionListener(e -> mainManager.goToCityListScreen());

        right.add(locationButton);

        // weather icon
        System.out.println(city.getCurrent().getRecommendation());
        BufferedImage weathIconTmp = ImageIO.read(city.getCurrent().getRecommendation().getWeatherIcon());
        Image weathIcon = weathIconTmp.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        JLabel weathIconLabel = new JLabel(new ImageIcon(weathIcon));
        right.add(weathIconLabel);

        weath.add(right);

        return weath;
    }

    private JPanel currentOutfit() throws IOException {
        JPanel outfit =  new JPanel();
        outfit.setLayout(new GridLayout(4,1));

        //System.out.println(city.getCurrent().getRecommendation().getAccesoriesIcon().toURI());
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

    private JPanel futureWeather() throws IOException {
        JTabbedPane tabbedPane = new JTabbedPane();
        BufferedImage accessoryIconTmp = ImageIO.read(city.getCurrent().getRecommendation().getAccesoriesIcon());
        Image accessoryIcon = accessoryIconTmp.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(accessoryIcon);

        JComponent hourly = timeWeather(true);
        hourly.setPreferredSize(new Dimension(StyleGuide.getScreenWidth()-10, 70));
        tabbedPane.addTab("Hourly", icon, hourly,
                "Hourly weather");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent weekly = timeWeather(false);
        tabbedPane.addTab("Weekly", icon, weekly,
                "Weekly weather");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JPanel x = new JPanel();
        x.add(tabbedPane);
        return x;
    }

    public JComponent timeWeather(boolean hourly) throws IOException {
        JComponent weath = new JLabel();
        weath.setLayout(new GridLayout(3, maxAccross));

        JLabel l;
        for (int i = 0; i < maxAccross; i++) {
            l = new JLabel((hourly) ? hourLab(city.getDaily().get(0)) : weekLab(city.getWeekly().get(0)));
            l.setFont(StyleGuide.getSmallFont());
            l.setHorizontalAlignment(SwingConstants.CENTER);
            weath.add(l);
        }
        for (int i = 0; i < maxAccross; i++) {
            BufferedImage iconTmp = ImageIO.read(city.getDaily().get(0).getRecommendation().getMainIcon());
            Image icon = iconTmp.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            weath.add(new JLabel(new ImageIcon(icon)));
        }
        for (int i = 0; i < maxAccross; i++) {
            l = new JLabel((hourly) ? hourTemp(city.getDaily().get(0)) : weekTemp(city.getWeekly().get(0)));
            l.setFont(StyleGuide.getSmallFont());
            l.setHorizontalAlignment(SwingConstants.RIGHT);
            weath.add(l);
        }

        return weath;
    }

    private String hourLab(Weather x) {
        return x.getHour() + "00";
    }
    private String hourTemp(Weather x) {
        return x.getOverall() + "";
    }
    private String weekLab(Weather x) {
        return x.getWeekDay();
    }
    private String weekTemp(Weather x) {
        return x.getHighLow();
    }


    public static void main(String[] args) throws Exception {
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH").parse("2019-05-21T07:00:00+01:00");
        System.out.println(StyleGuide.getHourFormat().format(date));

//        Map<String, String> f = new HashMap<>();
//        f.put("Temperature", "17.8");
//        f.put("WeatherText", "Cloudy");
//        f.put("WeatherIcon", "7");
//
//
//        Weather w = new Weather(
//                Recommender.recommend(f),
//                "Monday", new Date(), 10, f.get("WeatherText"),
//                Float.parseFloat(f.get("Temperature")), 20, 10,
//                Float.parseFloat(f.get("Temperature")));
//        ArrayList we = new ArrayList<Weather>();
//        we.add(w);
//
//
//        City c = new City("Test", we, we, w, 20, 10);
//        MainScreen gui = new MainScreen(c);
//        gui.setVisible(true);
//        System.out.println(Recommender.recommend(Fetcher.fetchCurrent(327200)));
    }



}
