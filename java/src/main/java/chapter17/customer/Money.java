package chapter17.customer;

/**
 * Just a wrapper to introduce the concept of money into the domain.
 */
public class Money implements Comparable<Money> {
    private final double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    @Override
    public int compareTo(Money other) {
        return Double.compare(this.amount, other.amount);
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
