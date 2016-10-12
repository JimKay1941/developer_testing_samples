using Microsoft.VisualStudio.TestTools.UnitTesting;
using Samples.Chapter09.RaffleDependencies;
using System.Collections.Generic;

namespace SamplesTests.Chapter09.RaffleDependencies
{
    // Shows how a factory method can be used to control the number of tickets.
    [TestClass]
    public class RaffleWithFactoryMethodTest
    {
        [TestMethod]
        public void RaffleHasFiveTickets()
        {
            var testedRaffle = new FiveTicketRaffle();
            Assert.AreEqual(5, testedRaffle.TicketCount);
        }
    }

    class FiveTicketRaffle : RaffleWithFactoryMethod
    {
        protected override ISet<int> CreateTickets()
        {
            return new HashSet<int> { 1, 2, 3, 4, 5 };
        }
    }
}
