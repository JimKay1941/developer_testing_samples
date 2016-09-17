package chapter05.assertion;

/**
 * This example shows how to use a built-in assertions. Doing it in this case
 * would be incorrect though, because the time class is a public class and its
 * users can supply incorrect values. Ensuring that callers follow the contract
 * using a mechanism that can be turned off is wrong.
 */
public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        assert hour >= 0 && hour < 24 :
                "Hour out of range";
        assert minute >= 0 && minute < 60 :
                "Minute out of range";
        this.hour = hour;
        this.minute = minute;
    }

    /* Execute via a main method, because we don't want to catch/ignore
     * java.lang.AssertionError in our tests.
     * Remember to supply the -ea flag to java.
     */
    public static void main(String[] args) {
        new Time(25, 1);
    }
}
