package ShopSystem;

abstract public class Product implements Comparable {
    protected String name;
    protected int rate;

    public Product(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract public int getRate();

    abstract public void setRate(int rate);

    public int compareTo(Object arg0) {
        Product product = (Product) arg0;
        return this.name.compareTo(product.name);
    }

    public String toString() {
        return "Product [name=" + name + ", rate=" + getRate() + "]";
    }
}
