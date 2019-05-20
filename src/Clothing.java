import java.io.File;

public class Clothing {
    private File accesoriesIcon;
    private File topIcon;
    private File bottomIcon;
    private File shoesIcon;
    private File mainIcon;
    private File weatherIcon;

    public Clothing(File accesoriesIcon, File topIcon, File bottomIcon, File shoesIcon, File mainIcon, File weatherIcon) {
        this.accesoriesIcon = accesoriesIcon;
        this.topIcon = topIcon;
        this.bottomIcon = bottomIcon;
        this.shoesIcon = shoesIcon;
        this.mainIcon = mainIcon;
        this.weatherIcon = weatherIcon;
    }

    public File getAccesoriesIcon() {
        return accesoriesIcon;
    }

    public File getTopIcon() {
        return topIcon;
    }

    public File getBottomIcon() {
        return bottomIcon;
    }

    public File getShoesIcon() {
        return shoesIcon;
    }

    public File getMainIcon() { return mainIcon; }

    public File getWeatherIcon() {
        return weatherIcon;
    }

}
