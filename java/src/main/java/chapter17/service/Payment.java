package chapter17.service;

import chapter17.customer.Money;

/**
 * Simplest possible identifiable payment.
 */
public class Payment {
    private final long referenceNumber;
    private final Money money;

    public Payment(long referenceNumber, Money money) {
        this.referenceNumber = referenceNumber;
        this.money = money;
    }
}
