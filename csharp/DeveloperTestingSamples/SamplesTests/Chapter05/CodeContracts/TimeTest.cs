using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Samples.Chapter05.CodeContracts;

namespace SamplesTests.Chapter05.CodeContracts
{
    /* This code isn't published in the book. It illustrates how contract
     * violations manifest themselves for common contracts.
     */
    [TestClass]
    public class TimeTest
    {
        [TestMethod]
        public void ValidHours()
        {
            new Time(0, 1);
            new Time(1, 1);
            new Time(15, 1);
            new Time(22, 1);
            new Time(23, 1);
        }

        /* Fails with ArgumentException because that's the exception associated
         * with Requires.
         */ 
        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void NegativeHourNotAccepted()
        {
            new Time(-1, 1);
        }

        /* Fails with ContractException, since no exception has been specified 
         * in Requires for minutes. The crude try/catch construct is there to 
         * illustrate that an exception called ContractException will be thrown.
         */ 
        [TestMethod]
        public void NegativeMinuteNotAccepted()
        {
            try
            {
                new Time(1, -1);
            }
            catch (Exception e) 
            {
                if (!e.GetType().FullName.EndsWith("ContractException")) 
                {
                    throw;
                }
            }
        }
    }
}
