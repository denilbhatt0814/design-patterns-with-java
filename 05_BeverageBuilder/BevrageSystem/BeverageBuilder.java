package BevrageSystem;

abstract public class BeverageBuilder {
    protected Beverage beverage;

    public BeverageBuilder() {
        beverage = new Beverage();
    }

    public Beverage getBeverage() {
        return this.beverage;
    }

    abstract public void chooseFlavour();

    abstract public void chooseSweetener();

}