package chapter17.net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This is just a stub to make the tests compile. A real-life allocator
 * would know about some kind of pool of IP addresses and constraints
 * for allocating them.
 */
public class IpAllocator {
    public static Inet4Address allocate() {
        try {
            return (Inet4Address) InetAddress.getByAddress(new byte[]{10, 0, 0, 1});
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
