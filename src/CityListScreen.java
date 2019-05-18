import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CityListScreen extends JFrame {

    DefaultListModel<String> model;

    CityListScreen()
    {
        super("City Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(StyleGuide.getScreenWidth(),StyleGuide.getScreenHeight());

        model = new DefaultListModel<>();
        model.addElement("Cambridge");
        model.addElement("London");
        add(createHeader(), BorderLayout.NORTH);
        add(createList(), BorderLayout.CENTER);

    }

    private JPanel createHeader()
    {
        JPanel header = new JPanel();
        header.setBackground(StyleGuide.getBackgroundColor());
        addBorder(header, "Search");
        JButton findNew = new JButton("Find a New City");
        findNew.setFont(StyleGuide.getRegularFont());
        findNew.setBackground(StyleGuide.getSecondaryColor());
        findNew.setForeground(Color.white);
        findNew.setUI(StyleGuide.getButtonStyle());
        header.add(findNew, BorderLayout.SOUTH);
        return header;
    }

    private JPanel createList()
    {
        JPanel list = new JPanel();
        list.setBackground(StyleGuide.getBackgroundColor());
        addBorder(list, "Saved Cities");
        list.setLayout(new GridLayout(1,1));
        JList<String> cities = new JList<>(model);

        cities.setCellRenderer(new CityListRenderer(cities, true));
        list.add(cities);
        return list;
    }

    private void addBorder(JComponent component, String title) {
        Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border tb = BorderFactory.createTitledBorder(etch,title);
        ((TitledBorder) tb).setTitleFont(StyleGuide.getRegularFont());
        component.setBorder(tb);

    }
    public static void main(String[] args) {
        JFrame city = new CityListScreen();
        city.setVisible(true);
    }
}
