using System;

namespace Samples.Chapter16.MethodDuplication
{
    // Emulating every legacy system's own implementation of date utilities.
    // This code is actually not in the book, only its Java counterpart.
    public class DateUtils
    {
        public static long DiffTime(DateTime t1, DateTime t2)
        {
            if (t1.Date != t2.Date)
            {
                throw new ArgumentException("Incomparable dates");
            }
            return (t2.Hour - t1.Hour) * 60;
        }

        public static long DiffTime_Revised(DateTime t1, DateTime t2)
        {
            if (t1.Date != t2.Date)
            {
                throw new ArgumentException("Incomparable dates");
            }
            return (t2.Hour * 60 + t2.Minute) - (t1.Hour * 60 + t1.Minute);
        }
    }
}
