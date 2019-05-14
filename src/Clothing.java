import java.nio.file.Path;

public class Clothing {
    private Path accesoriesIcon;
    private Path topIcon;
    private Path bottomIcon;
    private Path shoesIcon;

    public Clothing(Path accesoriesIcon, Path topIcon, Path bottomIcon, Path shoesIcon) {
        this.accesoriesIcon = accesoriesIcon;
        this.topIcon = topIcon;
        this.bottomIcon = bottomIcon;
        this.shoesIcon = shoesIcon;
    }

    public Path getAccesoriesIcon() {
        return accesoriesIcon;
    }

    public Path getTopIcon() {
        return topIcon;
    }

    public Path getBottomIcon() {
        return bottomIcon;
    }

    public Path getShoesIcon() {
        return shoesIcon;
    }
}
