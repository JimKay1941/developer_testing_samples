package chapter06.onboarding;

/**
 * While we can discuss whether the boundaries for allowed age make sense
 * (0 years means months?/is 120 enough?), this class shows that recurring
 * concepts and business rules should be encapsulated in object-oriented languages.
 * Handling them with primitive types is error prone.
 */
public class Age {
    private int years;

    public Age(int years) {
        if (years < 0 || years >= 120) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.years = years;
    }
}
