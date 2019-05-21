import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class StyleGuide {
    private static final int screenWidth = 375;
    private static final int screenHeight = 667;
    private static final Color backgroundColor = Color.white;
    private static final Color primaryBlue = new Color ( 82, 158, 202 );
    private static final Color secondaryColor = new Color (202, 88, 104);

    private static final String font = "Verdana";
    private static final Font largeFont= new Font(font,Font.BOLD,20);
    private static final Font regularFont= new Font(font,Font.PLAIN,15);
    private static final Font smallFont= new Font(font,Font.PLAIN,10);

    private static final File locationIcon = new File("icons/locationIcon.png");
    private static final File searchIcon = new File("icons/searchIcon.png");
    private static final File umbrellaIcon = new File("icons/umbrellaIcon.png");
    private static final File scarfIcon = new File("icons/scarfIcon.png");
    private static final File sunglassesIcon = new File("icons/sunglassesIcon.png");
    private static final File tShirtIcon = new File("icons/tShirtIcon.png");
    private static final File longSleevedShirtIcon = new File("icons/longSleevedShirtIcon.png");
    private static final File sweaterIcon = new File("icons/sweaterIcon.png");
    private static final File sweatshirtIcon = new File("icons/sweatshirtIcon.png");
    private static final File jacketIcon = new File("icons/jacketIcon.png");
    private static final File coatIcon = new File("icons/coatIcon.png");
    private static final File waterproofIcon = new File("icons/waterproofIcon.png");
    private static final File shortShortsIcon = new File("icons/shortShortsIcon.png");
    private static final File shortsIcon = new File("icons/shortsIcon.png");
    private static final File trousersIcon = new File("icons/trousersIcon.png");
    private static final File snowBootIcon = new File("icons/snowBootIcon.png");
    private static final File rainBootsIcon = new File("icons/rainBootsIcon.png");
    private static final File sneakersIcon = new File("icons/sneakersIcon.png");
    private static final File sandalsIcon = new File("icons/sandalsIcon.png");
    private static final File sunnyIcon = new File("icons/sunnyIcon.png");
    private static final File partlyCloudyIcon = new File("icons/partlyCloudyIcon.png");
    private static final File cloudyIcon = new File("icons/cloudyIcon.png");
    private static final File rainingIcon = new File("icons/rainingIcon.png");
    private static final File thunderstormIcon = new File("icons/thunderstormIcon.png");
    private static final File snowingIcon = new File("icons/snowingIcon.png");
    private static final File windyIcon = new File("icons/windyIcon.png");
    private static final File trashCan = new File("icons/trashcanIcon.png");
    private static final File emptyIcon = new File("icons/emptyIcon.png");

    private static final List<Integer> sunny = Arrays.asList(new Integer[] {1,2,33,34,30});
    private static final List<Integer> partlyCloudy = Arrays.asList(new Integer[] {3,4,5,35,36,37});
    private static final List<Integer> cloudy = Arrays.asList(new Integer[] {6,7,8,11,31,38});
    private static final List<Integer> rain = Arrays.asList(new Integer[] {12,13,14,18,39,40});
    private static final List<Integer> thunderstorm = Arrays.asList(new Integer[] {15,16,17,41,42});
    private static final List<Integer> snow = Arrays.asList(new Integer[] {19,20,21,22,23,24,25,26,29,43,44});
    private static final List<Integer> wind = Arrays.asList(new Integer[] {32});
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("d E");

    public static SimpleDateFormat getDateFormat() { return dateFormat; }

    public static List<Integer> getSunny() { return sunny; }

    public static List<Integer> getPartlyCloudy() { return partlyCloudy; }

    public static List<Integer> getCloudy() { return cloudy; }

    public static List<Integer> getRain() { return rain; }

    public static List<Integer> getThunderstorm() { return thunderstorm; }

    public static List<Integer> getSnow() { return snow; }

    public static List<Integer> getWind() { return wind; }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static Color getBackgroundColor() {
        return backgroundColor;
    }

    public static Font getLargeFont() { return largeFont; }

    public static Font getRegularFont() { return regularFont; }

    public static Font getSmallFont() { return smallFont; }

    public static File getLocationIcon() { return locationIcon; }

    public static File getSearchIcon() { return searchIcon; }

    public static File getUmbrellaIcon() {
        return umbrellaIcon;
    }

    public static File getScarfIcon() {
        return scarfIcon;
    }

    public static File getSunglassesIcon() {
        return sunglassesIcon;
    }

    public static File gettShirtIcon() {
        return tShirtIcon;
    }

    public static File getLongSleevedShirtIcon() {
        return longSleevedShirtIcon;
    }

    public static File getSweaterIcon() {
        return sweaterIcon;
    }

    public static File getSweatshirtIcon() {
        return sweatshirtIcon;
    }

    public static File getJacketIcon() {
        return jacketIcon;
    }

    public static File getCoatIcon() {
        return coatIcon;
    }

    public static File getWaterproofIcon() {
        return waterproofIcon;
    }

    public static File getShortShortsIcon() {
        return shortShortsIcon;
    }

    public static File getShortsIcon() {
        return shortsIcon;
    }

    public static File getTrousersIcon() {
        return trousersIcon;
    }

    public static File getSnowBootIcon() {
        return snowBootIcon;
    }

    public static File getRainBootsIcon() {
        return rainBootsIcon;
    }

    public static File getSneakersIcon() {
        return sneakersIcon;
    }

    public static File getSandalsIcon() {
        return sandalsIcon;
    }

    public static File getSunnyIcon() {
        return sunnyIcon;
    }

    public static File getPartlyCloudyIcon() {
        return partlyCloudyIcon;
    }

    public static File getCloudyIcon() {
        return cloudyIcon;
    }

    public static File getRainingIcon() {
        return rainingIcon;
    }

    public static File getThunderstormIcon() {
        return thunderstormIcon;
    }

    public static File getSnowingIcon() {
        return snowingIcon;
    }

    public static File getWindyIcon() {
        return windyIcon;
    }

    public static File getTrashCan() {
        return trashCan;
    }

    public static File getEmptyIcon() {
        return emptyIcon;
    }

    public static Color getPrimaryBlue() {
        return primaryBlue;
    }

    public static Color getSecondaryColor() {
        return secondaryColor;
    }

    public static String getFont() {
        return font;
    }

    public static StyledButtonUI getButtonStyle()
    {
        return  new StyledButtonUI();
    }

    private static class StyledButtonUI extends BasicButtonUI {

        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));
        }

        @Override
        public void paint (Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }

        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }
    }
}
