import java.awt.*;

public final class StyleGuide {
    private static final int screenWidth = 375;
    private static final int screenHeight = 667;
    private static final Color backgroundColor = Color.white;
    private static String font = "Verdana";
    private static Font largeFont= new Font(font,1,20);
    private static Font regularFont= new Font(font,0,15);
    private static Font smallFont= new Font(font,0,10);

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
}
