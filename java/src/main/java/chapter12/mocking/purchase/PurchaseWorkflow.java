package chapter12.mocking.purchase;

import chapter12.mocking.Campaign;

/**
 * A slightly contrived way of modelling a customer's interaction
 * with a shopping site, but it works well enough to illustrate
 * various types of mocks.
 */
public class PurchaseWorkflow {

    private Campaign campaign;
    private long customerId;
    private Purchase purchase = new Purchase();

    public PurchaseWorkflow(Campaign campaign) {
        this.campaign = campaign;
    }

    public PurchaseWorkflow usingExistingCustomer(long customerId) {
        this.customerId = customerId;

        // Do something intriguing with a customer object.
        return this;
    }

    public PurchaseWorkflow addItem(Item item) {
        purchase.addItem(item);
        return this;
    }

    public PurchaseWorkflow enterDiscountCode(String discountCode) {

        // This is what we really want to test!
        campaign.applyDiscount(customerId, discountCode, purchase);
        return this;
    }
}
