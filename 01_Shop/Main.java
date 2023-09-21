import ShopSystem.*;

public class Main {
    public static void main(String[] args) {
        Shop myShop = new Shop("Soap ki Shop");

        Product[] products = new Product[] {
                new NewProduct("Soap", 170),
                new NewProduct("Biscuit", 10),
                new NewProduct("Ballon", 50),
                new OldProduct("Balls", 50)
        };

        myShop.addManyProducts(products);
        myShop.listProducts();
    }
}
