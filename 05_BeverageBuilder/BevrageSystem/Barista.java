package BevrageSystem;

public class Barista {
    private BeverageBuilder beverageBuilder;

    public void setBeveragebuilder(BeverageBuilder beverageBuilder) {
        this.beverageBuilder = beverageBuilder;
    }

    public Beverage getBeverage() {
        return beverageBuilder.getBeverage();
    }

    public void brew() {
        beverageBuilder.chooseFlavour();
        beverageBuilder.chooseSweetener();
    }
}
