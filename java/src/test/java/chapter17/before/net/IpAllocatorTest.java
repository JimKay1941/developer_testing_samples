package chapter17.before.net;

import chapter17.net.IpAllocator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Shows the effects of not using assertion messages
 */
public class IpAllocatorTest {

    @Test
    public void noMessage() {
        assertNotNull(IpAllocator.allocate());
    }
}
