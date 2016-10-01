package chapter12.stubbing;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class contains variations of the "canonical" tests, which illustrates the most basic
 * problem with collaborators. The first test fails, the following show some solutions to
 * the problem. In the book, this example is in C#.
 */
public class StubbingTest {

    @Ignore(value = "Fails because there's no way to know what the collaborator will return")
    @Test
    public void canonicalTest() {
        TestedObject tested = new TestedObject(new ConcreteCollaborator());

        // In the book, this line appears as assertEquals(?, tested.computeSomething());
        assertEquals(1, tested.computeSomething());
    }

    // This test shows how to use a hand-crafted stub to control a collaborator's indirect input
    @Test
    public void canonicalTestWithStub() {
        TestedObject tested = new TestedObject(new CollaboratorStub());
        assertEquals(420, tested.computeSomething());
    }

    // Hand-crafted stubs can be parameterized
    @Test
    public void canonicalTestWithParameterizedStub() {
        final int knownValue = 2;
        TestedObject tested = new TestedObject(new ParameterizedStub(knownValue));
        assertEquals(knownValue * 42, tested.computeSomething());
    }
}

