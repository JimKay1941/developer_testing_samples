package chapter08.ruleengine;

public class PremiumRuleEngine {

    // This method is used to explain partitioning into equivalence classes.
    public double getPremiumFactor(int age) {
        if (age >= 18 && age < 24) {
            return 1.75;
        } else if (age >= 24 && age < 60) {
            return 1;
        } else if (age >= 60) {
            return 1.35;
        }
        throw new IllegalArgumentException("Age out of range");
    }
}
