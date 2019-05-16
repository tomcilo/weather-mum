import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
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

    private void addBorder(JComponent component, String title) {
        Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border tb = BorderFactory.createTitledBorder(etch,title);
        component.setBorder(tb);
    }

    private JPanel currentWeather() throws IOException {
        JPanel weath =  new JPanel();
        weath.setLayout(new GridLayout(3,2));

        JLabel tempText = new JLabel(city.getCurrent().getOverall() + "°");
        tempText.setFont(StyleGuide.getLargeFont());
        weath.add(tempText);

        JLabel descText = new JLabel(city.getCurrent().getDescription());
        descText.setFont(StyleGuide.getRegularFont());
        weath.add(descText);

        JLabel hlText = new JLabel(city.getCurrent().getHighLow());
        hlText.setFont(StyleGuide.getSmallFont());
        weath.add(hlText);
        
        BufferedImage myPicture = ImageIO.read(new File("icons/location_tmp.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        weath.add(picLabel);


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
