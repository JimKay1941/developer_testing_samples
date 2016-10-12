using System.Collections.Generic;

namespace Samples.Chapter09.RaffleDependencies
{

    // A more testable version of the raffle
    public class RaffleWithFactoryMethod
    {
        private ISet<int> tickets;

        public int TicketCount
        {
            get { return tickets.Count; }
        }

        public RaffleWithFactoryMethod()
        {
            tickets = CreateTickets();
        }

        protected virtual ISet<int> CreateTickets()
        {
            return new HashSet<int> { 1, 2, 3 };
        }
    }
}
