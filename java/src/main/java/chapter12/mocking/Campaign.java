package chapter12.mocking;

import chapter12.mocking.purchase.Purchase;

/**
 * Describes a campaign that applies some business rule to a purchase given a campaign code.
 */
public interface Campaign {
    void applyDiscount(long customerNumber, String discountCode, Purchase purchase);
}
