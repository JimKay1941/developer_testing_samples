using Samples.Chapter12.Stubbing;
using System;

namespace SamplesTests.Chapter12.Stubbing
{

    // Shows that a stub can be parameterized to achieve a degree of flexibility.
    class ParameterizedStub : ICollaborator
    {
        private int value;
        public ParameterizedStub(int value)
        {
            this.value = value;
        }
        public int ComputeAndReturnValue()
        {
            return value;
        }
    }

    // This class appears as "ParameterizedStub" in the book, because it builds on the previous one.
    class ParameterizedStubWithLogic : ICollaborator
    {
        private int value;
        public ParameterizedStubWithLogic(int value)
        {
            this.value = value;
        }
        public int ComputeAndReturnValue()
        {
            if (value < 10)
            {
                throw new InvalidOperationException();
            }
            return value;
        }
    }
}
