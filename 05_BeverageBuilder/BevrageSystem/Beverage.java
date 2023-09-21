package BevrageSystem;

public class Beverage {
    private String flavour;
    private String sweetener;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getSweetener() {
        return sweetener;
    }

    public void setSweetener(String sweetener) {
        this.sweetener = sweetener;
    }

    @Override
    public String toString() {
        return "Beverage [flavour=" + flavour + ", sweetener=" + sweetener + "]";
    }
}
