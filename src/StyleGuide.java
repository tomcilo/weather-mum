import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class StyleGuide {
    private static final int screenWidth = 375;
    private static final int screenHeight = 667;
    private static final Color backgroundColor = Color.white;

    private static String font = "Verdana";
    private static Font largeFont= new Font(font,Font.BOLD,20);
    private static Font regularFont= new Font(font,Font.PLAIN,15);
    private static Font smallFont= new Font(font,Font.PLAIN,10);

    private static final File locationIcon = new File("icons/locationIcon.png");
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


    private static int getScreenWidth() {
        return screenWidth;
    }

    private static int getScreenHeight() {
        return screenHeight;
    }

    private static Color getBackgroundColor() {
        return backgroundColor;
    }

    private static Font getLargeFont() { return largeFont; }

    private static Font getRegularFont() { return regularFont; }

    private static Font getSmallFont() { return smallFont; }

    private static File getLocationIcon() { return locationIcon; }

    private static File getUmbrellaIcon() {
        return umbrellaIcon;
    }

    private static File getScarfIcon() {
        return scarfIcon;
    }

    private static File getSunglassesIcon() {
        return sunglassesIcon;
    }

    private static File gettShirtIcon() {
        return tShirtIcon;
    }

    private static File getLongSleevedShirtIcon() {
        return longSleevedShirtIcon;
    }

    private static File getSweaterIcon() {
        return sweaterIcon;
    }

    private static File getSweatshirtIcon() {
        return sweatshirtIcon;
    }

    private static File getJacketIcon() {
        return jacketIcon;
    }

    private static File getCoatIcon() {
        return coatIcon;
    }

    private static File getWaterproofIcon() {
        return waterproofIcon;
    }

    private static File getShortShortsIcon() {
        return shortShortsIcon;
    }

    private static File getShortsIcon() {
        return shortsIcon;
    }

    private static File getTrousersIcon() {
        return trousersIcon;
    }

    private static File getSnowBootIcon() {
        return snowBootIcon;
    }

    private static File getRainBootsIcon() {
        return rainBootsIcon;
    }

    private static File getSneakersIcon() {
        return sneakersIcon;
    }

    private static File getSandalsIcon() {
        return sandalsIcon;
    }

    private static File getSunnyIcon() {
        return sunnyIcon;
    }

    private static File getPartlyCloudyIcon() {
        return partlyCloudyIcon;
    }

    private static File getCloudyIcon() {
        return cloudyIcon;
    }

    private static File getRainingIcon() {
        return rainingIcon;
    }

    private static File getThunderstormIcon() {
        return thunderstormIcon;
    }

    private static File getSnowingIcon() {
        return snowingIcon;
    }

    private static File getWindyIcon() {
        return windyIcon;
    }
}
