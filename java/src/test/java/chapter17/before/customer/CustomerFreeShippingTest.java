package chapter17.before.customer;

import chapter17.customer.Customer;
import chapter17.customer.Money;
import chapter17.customer.Product;
import chapter17.customer.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerFreeShippingTest {

    @Test
    public void productsInHistoryWithTotalPriceLessThan100_NoFreeShipping() {
        Customer customer = new Customer(1, "Mary", "King");
        Purchase purchase = new Purchase();

        // Not eligible for free shipping.
        purchase.addProduct(new Product(1, "Product", new Money(99)));
        customer.getPurchaseHistory().add(purchase);
        assertFalse(customer.hasFreeShipping());
    }

    @Test
    public void productsInHistoryWithTotalPriceGreaterThan100_GetFreeShipping() {
        Customer customer = new Customer(1, "Mary", "King");
        Purchase purchase = new Purchase();
        // This time the customer has passed the threshold
        // for free shipping by exceeding $100.
        purchase.addProduct(new Product(1, "Product", new Money(150)));
        customer.getPurchaseHistory().add(purchase);
        assertTrue(customer.hasFreeShipping());
    }
}
