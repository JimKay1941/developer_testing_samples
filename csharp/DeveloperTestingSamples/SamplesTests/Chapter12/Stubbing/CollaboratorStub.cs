using Samples.Chapter12.Stubbing;

namespace SamplesTests.Chapter12.Stubbing
{
    // Hand-crafted stub with fixed return value.
    class CollaboratorStub : ICollaborator
    {
        public int ComputeAndReturnValue()
        {
            return 10;
        }
    }
}
