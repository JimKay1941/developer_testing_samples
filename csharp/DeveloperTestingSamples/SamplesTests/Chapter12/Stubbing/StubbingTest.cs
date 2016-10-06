using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Samples.Chapter12.Stubbing;

namespace SamplesTests.Chapter12.Stubbing
{

    // This class contains variations of the "canonical" tests, which illustrates the most basic
    // problem with collaborators. The first test fails, the following show some solutions to
    // the problem. In the book, this example is in C#.
    [TestClass]
    public class StubbingTest
    {
        // Fails because there's no way to know what the collaborator will return
        [Ignore]
        [TestMethod]
        public void CanonicalTest()
        {
            var tested = new TestedObject(new ConcreteCollaborator());

            // In the book, this line appears as assertEquals(?, tested.ComputeSomething());
            Assert.AreEqual(1, tested.ComputeSomething());
        }

        // This test shows how to use a hand-crafted stub to control a collaborator's indirect input
        [TestMethod]
        public void CanonicalTestWithStub()
        {
            var tested = new TestedObject(new CollaboratorStub());
            Assert.AreEqual(420, tested.ComputeSomething());
        }

        // Hand-crafted stubs can be parameterized
        [TestMethod]
        public void CanonicalTestWithParameterizedStub()
        {
            const int knownValue = 2;
            TestedObject tested = new TestedObject(new ParameterizedStub(knownValue));
            Assert.AreEqual(knownValue * 42, tested.ComputeSomething());
        }
    }
}