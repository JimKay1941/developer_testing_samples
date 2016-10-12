using System.Collections.Generic;
using System.Linq;

namespace Samples.Chapter09.RaffleDependencies
{
    public class TicketsFactory
    {
        private int numberOfTickets;

        public TicketsFactory(int numberOfTickets)
        {
            this.numberOfTickets = numberOfTickets;
        }

        public ISet<int> CreateTickets()
        {
            return new HashSet<int>(Enumerable.Range(1, numberOfTickets));
        }
    }
}
