import java.io.File;
import java.nio.file.Path;

public class Clothing {
    private File accesoriesIcon;
    private File topIcon;
    private File bottomIcon;
    private File shoesIcon;

    public Clothing(File accesoriesIcon, File topIcon, File bottomIcon, File shoesIcon) {
        this.accesoriesIcon = accesoriesIcon;
        this.topIcon = topIcon;
        this.bottomIcon = bottomIcon;
        this.shoesIcon = shoesIcon;
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
}
