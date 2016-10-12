using Microsoft.VisualStudio.TestTools.UnitTesting;
using Samples.Chapter09.RaffleDependencies;
using System.Collections.Generic;

namespace SamplesTests.Chapter09.RaffleDependencies
{
    // Demonstrates how constructor injection can be used to take control of
    // indirect input.
    [TestClass]
    public class RaffleWithConstructorInjectionTest
    {
        [TestMethod]
        public void RaffleHasFiveTickets()
        {
            var testedRaffle = new Raffle(new HashSet<int> { 1, 2, 3, 4, 5 });
            Assert.AreEqual(5, testedRaffle.TicketCount);
        }
    }
}
