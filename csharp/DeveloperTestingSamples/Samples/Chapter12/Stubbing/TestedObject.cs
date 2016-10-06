namespace Samples.Chapter12.Stubbing
{
    
    // Generic object that has a collaborator.
    public class TestedObject
    {
        private ICollaborator collaborator;

        public TestedObject(ICollaborator collaborator)
        {
            this.collaborator = collaborator;
        }

        public int ComputeSomething()
        {
            return 42 * collaborator.ComputeAndReturnValue();
        }
    }
}
