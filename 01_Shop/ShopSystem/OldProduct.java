package ShopSystem;

public class OldProduct extends Product {

    private int discount = 10;

    public OldProduct(String name, int rate) {
        super(name, rate);
    }

    public int getRate() {
        return rate - (rate * discount / 100);
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
