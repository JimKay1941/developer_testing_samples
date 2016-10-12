using Microsoft.VisualStudio.TestTools.UnitTesting;
using Samples.Chapter09.RaffleDependencies;

namespace SamplesTests.Chapter09.RaffleDependencies
{

    // Shows how a factory can be used to control the number of tickets.
    [TestClass]
    public class RaffleWithFactoryTest
    {
        [TestMethod]
        public void RaffleHasFiveTickets()
        {
            var testedRaffle = new Raffle(new TicketsFactory(5));
            Assert.AreEqual(5, testedRaffle.TicketCount);
        }
    }
}
