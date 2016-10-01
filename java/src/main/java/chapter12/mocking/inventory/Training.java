package chapter12.mocking.inventory;

import chapter12.mocking.purchase.Item;

/**
 * Simplest possible training in an online bookstore that also sells trainings.
 */
public class Training extends Item {

    private String name;

    public Training(String name, double price) {
        super(price);
        this.name = name;
    }
}
