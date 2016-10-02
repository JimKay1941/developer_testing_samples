using System;

namespace Samples.Chapter12.Stubbing
{

    
    // Concrete implementation of the supposed collaborator with a method
    // that returns something unpredictable.
    public class ConcreteCollaborator : ICollaborator
    {
        public int ComputeAndReturnValue()
        {
            return DateTime.Now.Hour * 60;
        }
    }
}
