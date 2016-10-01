package chapter17.customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Groups a number of products into a purchase.
 */
public class Purchase {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Money getTotalPrice() {
        Money sum = new Money(0);
        for (Product product : products) {
            sum = sum.add(product.getPrice());
        }
        return sum;
    }

}
