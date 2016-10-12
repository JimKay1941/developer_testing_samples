using Microsoft.VisualStudio.TestTools.UnitTesting;
using Samples.Chapter09.RaffleDependencies;

namespace SamplesTests.Chapter09.RaffleDependencies
{
    // This class shows that magic knowledge is needed to determine
    // the number of tickets in the raffle without manipualting it somehow.
    // This test doesn't really appear in the book.
    [TestClass]
    public class RaffleTest
    {
        [TestMethod]
        public void TryObtainingTheNumberOfTicketsInTheRaffle()
        {
            var testedRaffle = new Raffle();

            // Use magic knowledge
            Assert.AreEqual(3, testedRaffle.TicketCount);
        }
    }
}
