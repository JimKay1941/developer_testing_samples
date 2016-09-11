package chapter05.corejava;

/**
 * In the book, this example appears in a section that says that assertions
 * shouldn't be used when checking arguments in public APIs, like in a class
 * that represents time.
 */
public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour out of range: " + hour);
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute out of range: " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}
