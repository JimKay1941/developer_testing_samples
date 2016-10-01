package chapter17.customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a number of purchases. A realistic implementation would at least care about time.
 */
public class PurchaseHistory {

    List<Purchase> purchases = new ArrayList<>();

    public void add(Purchase purchase) {
        purchases.add(purchase);
    }

    public Money getTotalSum() {
        Money sum = new Money(0);
        for (Purchase purchase : purchases) {
            sum = sum.add(purchase.getTotalPrice());
        }
        return sum;
    }
}
