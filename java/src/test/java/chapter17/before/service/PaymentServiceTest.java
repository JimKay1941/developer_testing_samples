package chapter17.before.service;

import chapter17.customer.Money;
import chapter17.service.Payment;
import chapter17.service.PaymentRepository;
import chapter17.service.PaymentService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Shows that a test class that tests too much (or just mixes interaction
 * and state-based testing) will often resort to apologetic comments in the
 * test initializer. The solution: split up the test class!
 */
public class PaymentServiceTest {

    private PaymentService testedService;
    private PaymentRepository paymentRepositoryStub;

    @Before
    public void setUp() {
        testedService = new PaymentService();

        // The checksum and batch tests won't need
        // this, but this mock won't break them.
        paymentRepositoryStub = mock(PaymentRepository.class);
        testedService.setPaymentRepository(paymentRepositoryStub);
    }

    @Test
    public void findPaymentByReferenceNumber_paymentExists() {
        when(paymentRepositoryStub.getPayment(1000000))
                .thenReturn(new Payment(1000000, new Money(500.0)));
        testedService.findPaymentByReferenceNumber(10000009);
    }

    // 10 more tests like this

    @Test
    public void checksumPayment_validPayment() {
        testedService.checksum(new Payment(1232134234, new Money(100.0)));
    }

    // 10 more algorithmic tests
}
