package chapter16.methodduplication;

import java.util.Date;

/**
 * Emulating every legacy system's own implementation of date utilities.
 * Even using deprecated methods :)
 */
public class DateUtils {
    public static long diffTime(Date t1, Date t2) {
        if (t1.getDate() != t2.getDate()) {
            throw new IllegalArgumentException(
                    "Dates must be equal for comparison to work");
        }
        return (t2.getHours() - t1.getHours()) * 60;
    }

    public static long diffTime_revised(Date t1, Date t2) {
        if (t1.getDate() != t2.getDate()) {
            throw new IllegalArgumentException(
                    "Dates must be equal for comparison to work");
        }
        return (t2.getHours() * 60 + t2.getMinutes())
                - (t1.getHours() * 60 + t1.getMinutes());
    }
}
