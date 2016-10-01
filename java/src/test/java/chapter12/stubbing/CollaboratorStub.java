package chapter12.stubbing;

/**
 * Hand-crafted stub with fixed return value.
 */
public class CollaboratorStub implements Collaborator {

    @Override
    public int computeAndReturnValue() {
        return 10;
    }
}
