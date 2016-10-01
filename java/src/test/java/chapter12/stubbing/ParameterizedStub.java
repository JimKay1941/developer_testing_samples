package chapter12.stubbing;

/**
 * Shows that a stub can be parameterized to achieve a degree of flexibility.
 */
public class ParameterizedStub implements Collaborator {

    private int value;

    public ParameterizedStub(int value) {
        this.value = value;
    }

    @Override
    public int computeAndReturnValue() {
        return value;
    }
}
