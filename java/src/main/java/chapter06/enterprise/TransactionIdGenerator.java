package chapter06.enterprise;

import chapter06.enterprise.domain.TransactionId;

/**
 * This is just a stub to make the example compile!
 * An actual implementation would use some nifty algorithm to generate
 * a unique transaction id.
 */
public class TransactionIdGenerator {
    public TransactionId generateId() {
        return new TransactionId();
    }
}
