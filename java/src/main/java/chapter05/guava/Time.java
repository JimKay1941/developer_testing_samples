package chapter05.guava;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Time class using Guava to ensure that the arguments are valid.
 */
public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        checkArgument(hour >= 0 && hour <= 23,
                "Valid hours are between 0 and 23");
        checkArgument(minute >= 0 && minute <= 59,
                "Valid minutes are between 0 and 59");
        this.hour = hour;
        this.minute = minute;
    }
}
