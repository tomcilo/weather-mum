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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;
import java.util.stream.*;

public class SearchScreen extends JPanel  {
    private JTextField tf;
    private DefaultListModel<City> model;

    private AppManager mainManager;

    SearchScreen(AppManager mainManager)
    {
        this.mainManager = mainManager;

        setSize(StyleGuide.getScreenWidth(),StyleGuide.getScreenHeight());
        setLayout(new BorderLayout());

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
        exit.addActionListener(e -> mainManager.goToCityListScreen());
        return exit;
    }

    private JPanel createSearchPanel() 
    {
        JPanel heading = new JPanel();
        heading.setBackground(StyleGuide.getBackgroundColor());
        tf = new JTextField(12);
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
                if(tf.getText().length()!=0)
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
            List<City> cityNames = Fetcher.fetchAutocompletedCities(prefix);//.stream().map(x -> x.getDisplayName()).collect(Collectors.toList());
            for(City s:cityNames)
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
        model = new DefaultListModel<City>();
        JList<City> cityJList = new JList<City>(model);
        cityJList.setCellRenderer(new CityListRenderer(cityJList, false, null));
        cityJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                JList<City> list = (JList<City>) e.getSource();
                City c = list.getSelectedValue();

                mainManager.searchScreenCitySelected(c);
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


    public static void main(String[] args) throws IOException {
        JFrame search = new JFrame();
        search.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        search.setSize(StyleGuide.getScreenWidth(),StyleGuide.getScreenHeight());
        search.add(new SearchScreen(new AppManager()));
        search.setVisible(true);

    }

}
