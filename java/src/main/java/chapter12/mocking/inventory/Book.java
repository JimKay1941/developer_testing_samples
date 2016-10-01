package chapter12.mocking.inventory;

import chapter12.mocking.purchase.Item;

/**
 * Simplest possible book in an online bookstore.
 */
public class Book extends Item {
    private final String title;

    public Book(String title, double price) {
        super(price);
        this.title = title;
    }
}
