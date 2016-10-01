package chapter12.spying;

import chapter12.mocking.Campaign;
import chapter12.mocking.purchase.Purchase;
import chapter12.mocking.purchase.PurchaseWorkflow;
import org.junit.Test;

import static chapter12.mocking.inventory.Inventory.getBookByTitle;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * This class demonstrates the use of a spy implemented by hand and
 * how it differs from a mock object.
 */
public class SpyTest {

    // Differs from a mock object by having the assertions in the
    // test, not the test double.
    @Test
    public void demonstrateSpy() {
        Purchase expectedPurchase
                = new Purchase(getBookByTitle("Refactoring"));
        CampaignSpy campaignSpy = new CampaignSpy();
        new PurchaseWorkflow(campaignSpy)
                .addItem(getBookByTitle("Refactoring"))
                .usingExistingCustomer(1234567)
                .enterDiscountCode("WEEKEND DEAL");
        assertThat(campaignSpy.customerNumber, greaterThan(0L));
        assertEquals("WEEKEND DEAL", campaignSpy.discountCode);
        assertEquals(expectedPurchase, campaignSpy.purchase);
    }

    private class CampaignSpy implements Campaign {
        public long customerNumber;
        public String discountCode;
        public Purchase purchase;

        @Override
        public void applyDiscount(long customerNumber,
                                  String discountCode,
                                  Purchase purchase) {
            this.customerNumber = customerNumber;
            this.discountCode = discountCode;
            this.purchase = purchase;
        }
    }
}
