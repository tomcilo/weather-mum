import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchScreen extends JFrame  {
    JTextField tf;
    DefaultListModel<String> model;

    SearchScreen()
    {
        super("Search Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(StyleGuide.getScreenWidth(),StyleGuide.getScreenHeight());


        add(createSearchPanel(),BorderLayout.NORTH);

        add(createCityPanel(),BorderLayout.CENTER);
    }

    public JButton createExit()
    {
        JButton exit = new JButton("Back");
        exit.setFont(StyleGuide.getSmallFont());
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.white);
        exit.setUI(StyleGuide.getButtonStyle());
        return exit;
    }

    private JPanel createSearchPanel()
    {
        JPanel heading = new JPanel();
        heading.setBackground(StyleGuide.getBackgroundColor());
        tf = new JTextField(15);
        tf.setFont(StyleGuide.getRegularFont());


        //tf.addActionListener(this);
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                //updateCityPanel(tf.getText()+e.getKeyChar());
            }
        });

        heading.add(createExit());
        heading.add(tf);
        JButton search =  new JButton();

        ImageIcon icon = new ImageIcon(String.valueOf(StyleGuide.getSearchIcon()));

        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(newimg);

        search.setIcon(icon);
        search.setUI(StyleGuide.getButtonStyle());

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCityPanel(tf.getText());
            }
        });
        heading.add(search);
        addBorder(heading,"Enter City Name");
        return  heading;
    }

    private void updateCityPanel(String prefix)
    {
        model.clear();

        try {
            List<String> cityNames = Fetcher.fetchAutocompletedCities(prefix);
            for(String s:cityNames)
            {
                model.addElement(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private JPanel createCityPanel() {
        JPanel cities = new JPanel();
        addBorder(cities,"Cities");
        cities.setLayout(new GridLayout(1,1));
        List<City> cityList = new ArrayList<>();
        model = new DefaultListModel<String>();
        JList<String> cityJList = new JList<String>(model);
        cityJList.setCellRenderer(new CityListRenderer(cityJList, false));
        cityJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                JList<String> list = (JList<String>) e.getSource();
                String c = list.getSelectedValue();

                System.out.println(c);
            }
        });

        JScrollPane scroll = new JScrollPane(cityJList);

        cities.setBackground(StyleGuide.getBackgroundColor());
        cities.add(scroll);


        return cities;
    }

    private City createDummyCity()
    {
        Weather w = new Weather(
                new Clothing(StyleGuide.getUmbrellaIcon(), StyleGuide.gettShirtIcon(),
                        StyleGuide.getShortsIcon(), StyleGuide.getShortsIcon(), StyleGuide.getSunnyIcon(), StyleGuide.getSunnyIcon()),
                "Monday", new Date(), 10, "Sunny", 18, 20, 10, 20);
        ArrayList we = new ArrayList<Weather>();
        we.add(w);


        City c = new City("Test", we, we, w, 20, 10);
        return c;
    }

    private void addBorder(JComponent component, String title) {
        Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border tb = BorderFactory.createTitledBorder(etch,title);
        ((TitledBorder) tb).setTitleFont(StyleGuide.getRegularFont());
        component.setBorder(tb);

    }

}
