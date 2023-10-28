package ArturKuznetsov.lab3.task5;

import ArturKuznetsov.lab3.task5.exceptions.NotImportedProductException;
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

    public void showFirstImportedThenLocal() {
        StringBuilder importedProducts = new StringBuilder();
        StringBuilder localProducts = new StringBuilder();
        for (Product product : products) {
            try {
                product.isImportedException();
                importedProducts.append(product.displayProductInfo()).append("\n");
            } catch (NotImportedProductException e) {
                localProducts.append(product.displayProductInfo()).append("\n");
            }
        }
        System.out.println(importedProducts);
        System.out.println(localProducts);
    }
}
