import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainScreen extends JFrame {
    private City city;

    public MainScreen(City city) {
        super(city.getDisplayName());
        this.city = city;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(StyleGuide.getScreenWidth(), StyleGuide.getScreenHeight());

        add(createControlPanel(), BorderLayout.SOUTH);


    }

    private JPanel createControlPanel() {
        JPanel ctrl =  new JPanel();

        JButton back = new JButton("< Back");
        ctrl.add(back);

        return ctrl;
    }

    public static void main(String[] args) throws java.io.IOException {
        Weather w = null;

        City c = new City("Test", new ArrayList<Weather>(),
                new ArrayList<Weather>(), w, 20, 10);
        MainScreen gui = new MainScreen(c);
        gui.setVisible(true);
    }



}
