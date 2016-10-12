using Microsoft.VisualStudio.TestTools.UnitTesting;
using Samples.Chapter09.RaffleDependencies;

namespace SamplesTests.Chapter09.RaffleDependencies
{
    // A bit over the top, but shows how a factory can be used to 
    // control the number of tickets.
    [TestClass]
    public class RaffleWithBuilderTest
    {
        [TestMethod]
        public void RaffleHasFiveTickets()
        {
            var builder = new TicketsBuilder().StartingAt(1).EndingWith(5);
            Raffle testedRaffle = new Raffle(builder);
            Assert.AreEqual(5, testedRaffle.TicketCount);
        }
    }
}
