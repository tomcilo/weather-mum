import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
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
    DefaultListModel<City> model;

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
        return exit;
    }

    private JPanel createSearchPanel()
    {
        JPanel heading = new JPanel();

        tf = new JTextField(20);

        tf.setBounds(130, 20, 200, 20);


        //tf.addActionListener(this);
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                System.out.println("You searched " + tf.getText()+e.getKeyChar());
                updateCityPanel(tf.getText()+e.getKeyChar());
            }
        });


        heading.add(tf);
        heading.add(createExit());
        addBorder(heading,"Enter City Name");
        return  heading;
    }

    private void updateCityPanel(String prefix)
    {
        model.clear();
        List<City> cityList = new ArrayList<City>();
        cityList.add(createDummyCity());
        model.addElement(createDummyCity());
       // model.addAll(cityList);
        //model.addAll(cityList);
    }
    private JPanel createCityPanel() {
        JPanel cities = new JPanel();
        addBorder(cities,"Cities");
        cities.setLayout(new GridLayout(1,1));
        List<City> cityList = new ArrayList<>();
        model = new DefaultListModel<City>();
        //model.addAll(cityList);
        JList<City> cityJList = new JList<City>(model);
        cityJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                JList<City> list = (JList<City>) e.getSource();
                City c = list.getSelectedValue();

                System.out.println(c.getDisplayName());
            }
        });

        JScrollPane scroll = new JScrollPane(cityJList);

        cities.add(scroll);

        return cities;
    }

    private City createDummyCity()
    {
        Weather w = new Weather(StyleGuide.getSunnyIcon(), StyleGuide.getSunnyIcon(),
                new Clothing(StyleGuide.getUmbrellaIcon(), StyleGuide.gettShirtIcon(),
                        StyleGuide.getShortsIcon(), StyleGuide.getShortsIcon()),
                "Monday", new Date(), 10, "Sunny", 18, 20, 10, 20);
        ArrayList we = new ArrayList<Weather>();
        we.add(w);


        City c = new City("Test", we, we, w, 20, 10);
        return c;
    }

    private void addBorder(JComponent component, String title) {
        Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border tb = BorderFactory.createTitledBorder(etch,title);
        component.setBorder(tb);
    }

}
