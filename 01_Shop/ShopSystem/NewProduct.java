package ShopSystem;

public class NewProduct extends Product {

    public NewProduct(String name, int rate) {
        super(name, rate);
    }

    public NewProduct(String name) {
        super(name);
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
