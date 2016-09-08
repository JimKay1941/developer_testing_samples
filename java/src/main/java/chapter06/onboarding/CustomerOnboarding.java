package chapter06.onboarding;

/**
 * In the book, this example illustrates that care must be taken with important
 * concepts, such as age. If they're handled as integers, then there are going to
 * be if statements here and there in the code, instead of in a class that knows
 * about the concept's boundary values.
 */
public class CustomerOnboarding {

    public void signup(String firstname, String lastname, int age) {
        if (age < 0 || age >= 120) {
            throw new IllegalArgumentException("Invalid age");
        } else if (age <= 18) {
            throw new UnderAgedException();
        }

        // Rest of the code that performs the signup
    }
}
