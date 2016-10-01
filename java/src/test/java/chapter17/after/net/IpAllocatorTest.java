package chapter17.after.net;

import chapter17.net.IpAllocator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Shows the effects of using assertion messages
 */
public class IpAllocatorTest {

    // A good assertion message can be helpful (excuse the test name)
    @Test
    public void goodMessage() {
        assertNotNull("Failed to allocate IP address", IpAllocator.allocate());
    }

    // A bad assertion message just adds to the confusion (excuse the test name)
    @Test
    public void badMessage() {
        assertNotNull("IP address", IpAllocator.allocate());
    }
}
