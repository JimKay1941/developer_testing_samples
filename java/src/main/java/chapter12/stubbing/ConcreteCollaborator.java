package chapter12.stubbing;

import java.time.LocalTime;

/**
 * Concrete implementation of the supposed collaborator with a method
 * that returns something unpredictable.
 */
public class ConcreteCollaborator implements Collaborator {

    @Override
    public int computeAndReturnValue() {
        return LocalTime.now().getHour() * 60;
    }
}
