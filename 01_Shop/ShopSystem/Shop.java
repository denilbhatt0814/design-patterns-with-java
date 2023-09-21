package ShopSystem;

import java.util.*;

public class Shop {

    private String name;
    private Set<Product> products;

    public Shop(String name, Product[] products) {
        this.name = name;
        this.products = new TreeSet<Product>(Arrays.asList(products));
    }

    public Shop(String name) {
        this.name = name;
        products = new TreeSet<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addManyProducts(Product[] products) {
        this.products.addAll(new TreeSet<Product>(Arrays.asList(products)));
    }

    public void listProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}