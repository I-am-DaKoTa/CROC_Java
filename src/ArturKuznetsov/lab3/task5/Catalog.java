package ArturKuznetsov.lab3.task5;

import ArturKuznetsov.lab3.task5.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showAllCatalog() {
        for (Product product : products) {
            System.out.println(product.displayProductInfo());
        }
    }
}
