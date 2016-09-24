package chapter17.after.customer;

import chapter17.customer.Customer;
import chapter17.customer.Money;
import chapter17.customer.Product;
import chapter17.customer.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Illustrates how a factory method can eliminate the need for comments.
 */
public class CustomerFreeShippingTest {

    @Test
    public void productsInHistoryWithTotalPriceLessThan100_NoFreeShipping() {
        Customer customerWithoutFreeShipping
                = customerWithTotalPurchaseAmount(99);
        assertFalse(customerWithoutFreeShipping.hasFreeShipping());
    }

    @Test
    public void productsInHistoryWithTotalPriceGreaterThan100_GetFreeShipping() {
        Customer customerWithFreeShipping
                = customerWithTotalPurchaseAmount(150);
        assertTrue(customerWithFreeShipping.hasFreeShipping());
    }

    private Customer customerWithTotalPurchaseAmount(double amount) {
        Customer customer = new Customer(1, "Mary", "King");
        Purchase purchase = new Purchase();
        purchase.addProduct(new Product(1, "Product", new Money(amount)));
        customer.getPurchaseHistory().add(purchase);
        return customer;
    }
}
