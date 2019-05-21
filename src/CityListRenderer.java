import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class CityListRenderer extends DefaultListCellRenderer {

    /*Thank you http://stackoverflow.com/a/18589264/909085*/

    CustomLabel renderer;
    private static ImageIcon trashCan = new ImageIcon (String.valueOf(StyleGuide.getTrashCan()));
    private boolean trash;

    private AppManager mainManager;

    public CityListRenderer(final JList list, boolean trash, AppManager mainManager)
    {
        super();
        this.trash = trash;
        this.mainManager = mainManager;
        renderer = new CustomLabel(this.trash);

        Image image = trashCan.getImage(); // transform it
        Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        trashCan = new ImageIcon(newimg);

        if(this.trash) {
            list.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        int index = list.locationToIndex(e.getPoint());
                        if (index != -1 && list.isSelectedIndex(index)) {
                            Rectangle rect = list.getCellBounds(index, index);
                            Point pointWithinCell = new Point(e.getX() - rect.x, e.getY() - rect.y);
                            Rectangle crossRect = new Rectangle(rect.width - 9 - 5 - trashCan.getIconWidth() / 2,
                                    rect.height / 2 - trashCan.getIconHeight() / 2, trashCan.getIconWidth(), trashCan.getIconHeight());
                            if (crossRect.contains(pointWithinCell)) {
                                DefaultListModel model = (DefaultListModel) list.getModel();
                                model.remove(index);
                            }
                            else {
                                mainManager.cityListScreenCitySelected((City) list.getModel().getElementAt(index));
                            }
                        }
                    }
                }
            });
        }
    }

    @Override
    public Component getListCellRendererComponent (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus )
    {
        renderer.setSelected ( isSelected );
        renderer.setData ( ((City) value).toString() );
        return renderer;
    }


    /**
     * Label that has some custom decorations.
     */
    private static class CustomLabel extends JLabel
    {

        private boolean selected;
        private String name;
        private boolean trash;

        public CustomLabel (boolean trash)
        {
            super ();
            this.trash=trash;
            setOpaque ( false );
            setBorder ( BorderFactory.createEmptyBorder ( 0,  5, 0, 40 ) );
            setFont(StyleGuide.getLargeFont());
        }

        private void setSelected ( boolean selected )
        {
            this.selected = selected;
            setForeground ( selected ? Color.WHITE : Color.BLACK );
        }

        private void setData ( String data )
        {
            this.name = data;
            setText ( name );

        }

        @Override
        protected void paintComponent ( Graphics g )
        {
            Graphics2D g2d = ( Graphics2D ) g;
            g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

            if ( selected )
            {
                Area area =  new Area ( new RoundRectangle2D.Double ( 0, 3, getWidth (), 50, 6, 6 ) );
                g2d.setPaint ( StyleGuide.getPrimaryBlue() );
                g2d.fill ( area );
            }
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);


            if(trash)
                g2d.drawImage ( trashCan.getImage (), getWidth () - 9 - 5 - trashCan.getIconWidth () / 2, getHeight () / 2 - trashCan.getIconHeight () / 2, null );

            super.paintComponent ( g );
        }

        @Override
        public Dimension getPreferredSize ()
        {
            final Dimension ps = super.getPreferredSize ();
            ps.height = 50;
            return ps;
        }
    }
}


