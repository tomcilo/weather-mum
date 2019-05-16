import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class StyleGuide {
    private static final int screenWidth = 375;
    private static final int screenHeight = 667;
    private static final Color backgroundColor = Color.white;

    private static String font = "Verdana";
    private static Font largeFont= new Font(font,1,20);
    private static Font regularFont= new Font(font,0,15);
    private static Font smallFont= new Font(font,0,10);

    private static final File locationIcon = new File("icons/location_tmp.png");
    private static final File umbrellaIcon = new File("icons/umbrella.png");
    private static final File scarfIcon = new File("icons/scarf.png");
    private static final File sunglassesIcon = new File("icons/sunglasses.png");
    private static final File tShirtIcon = new File("icons/tShirt.png");
    private static final File longSleevedShirtIcon = new File("icons/longSleevedShirt.png");
    private static final File sweaterIcon = new File("icons/sweater.png");
    private static final File sweatshirtIcon = new File("icons/sweatshirt.png");
    private static final File jacketIcon = new File("icons/jacket.png");
    private static final File coatIcon = new File("icons/coat.png");
    private static final File waterproofIcon = new File("icons/waterproof.png");
    private static final File shortShortsIcon = new File("icons/shortShorts.png");
    private static final File shortsIcon = new File("icons/shorts.png");
    private static final File trousersIcon = new File("icons/trousers.png");
    private static final File snowBootIcon = new File("icons/snowBoot.png");
    private static final File rainBootsIcon = new File("icons/rainBoots.png");
    private static final File sneakersIcon = new File("icons/sneakers.png");
    private static final File sandalsIcon = new File("icons/sandals.png");
    private static final File sunnyIcon = new File("icons/sunny.png");
    private static final File partlyCloudyIcon = new File("icons/partlyCloudy.png");
    private static final File cloudyIcon = new File("icons/cloudy.png");
    private static final File rainingIcon = new File("icons/raining.png");
    private static final File thunderstormIcon = new File("icons/thunderstorm.png");
    private static final File snowingIcon = new File("icons/snowing.png");
    private static final File windyIcon = new File("icons/windy.png");


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
}
