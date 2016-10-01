package chapter17.customer;

/**
 * A _very_ simple product...
 */
public class Product {
    private long id;
    private String description;
    private Money price;

    public Product(long id, String description, Money price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }
}
