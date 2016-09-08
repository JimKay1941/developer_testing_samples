package chapter06.enterprise.domain;

/**
 * This is just a stub to make the example compile!
 * An actual implementation would store all information needed to create
 * an actual invoice: name, address, amount, tax details, etc.
 */
public class Invoice {

    private TransactionId transactionId;

    public void setTransactionId(TransactionId transactionId) {
        this.transactionId = transactionId;
    }
}
