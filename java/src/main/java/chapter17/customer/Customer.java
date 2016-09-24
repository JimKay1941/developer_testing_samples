package chapter17.customer;

/**
 * A simplified customer domain object.
 */
public class Customer {
    private final long id;
    private final String firstName;
    private final String lastName;
    private PurchaseHistory purchaseHistory;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        purchaseHistory = new PurchaseHistory();
    }

    public boolean hasFreeShipping() {
        // This would really not be here in production code
        final Money freeShippingTreshhold = new Money(100);
        return purchaseHistory.getTotalSum().compareTo(freeShippingTreshhold) >= 0;
    }

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }
}

