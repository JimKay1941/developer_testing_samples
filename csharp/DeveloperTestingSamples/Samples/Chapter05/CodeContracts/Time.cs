using System;
using System.Collections.Generic;
using System.Diagnostics.Contracts;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Samples.Chapter05.CodeContracts
{
    /* This implementation of the time class illustrates precondition
     * checks with CodeContracts. The different ways of specifying Requires
     * will result in two different exceptions.
     */ 
    public class Time
    {
        private int hour;
        private int minute;

        public Time(int hour, int minute)
        {
            Contract.Requires<ArgumentException>
                (hour >= 0 && hour <= 23);
            Contract.Requires(minute >= 0 && minute <= 59);
            this.hour = hour;
            this.minute = minute;
        }
    }
}
