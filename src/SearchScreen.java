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
import java.util.List;

public class SearchScreen extends JFrame implements ActionListener {
    JTextField tf;
    JButton search;



    SearchScreen()
    {
        super("Search Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(StyleGuide.getScreenWidth(),StyleGuide.getScreenHeight());

        add(createSearchPanel(),BorderLayout.NORTH);
        add(createCityPanel(),BorderLayout.CENTER);
        add(search, BorderLayout.SOUTH);
    }
    public void createSearchScreen()
    {

    }

    private JPanel createSearchPanel()
    {
        JPanel heading = new JPanel();

        tf = new JTextField(20);

        tf.setBounds(130, 20, 200, 20);

        search = new JButton("Submit");

        search.setBounds(50, 50, 100, 20);

        //tf.addActionListener(this);
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                System.out.println("You searched " + tf.getText() + e.getKeyChar());
            }
        });
        search.addActionListener(this);
        heading.add(tf);
        addBorder(heading,"Enter City Name");
        return  heading;
    }

    private JPanel createCityPanel() {
        JPanel cities = new JPanel();
        addBorder(cities,"Cities");
        cities.setLayout(new GridLayout(1,1));
        List<City> cityList = null;
        JList<City> cityJList = new JList<City>(cityList.toArray(new City[cityList.size()]));
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

    private void addBorder(JComponent component, String title) {
        Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border tb = BorderFactory.createTitledBorder(etch,title);
        component.setBorder(tb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You searched " + tf.getText());
    }

}
