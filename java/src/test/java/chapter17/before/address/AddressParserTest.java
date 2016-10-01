package chapter17.before.address;

import chapter17.address.AddressParser;
import chapter17.address.domain.ParsedAddress;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Shows a test can contains a magic number and a little too much
 * knowledge in an argument.
 */
public class AddressParserTest {

    private AddressParser addressParser = new AddressParser();

    @Test
    public void parse_simpleMisspellingsAreTolerated() {
        ParsedAddress address = addressParser.parse("Sesame streat 123", 1);
        assertEquals("Sesame street", address.streetName);
    }
}
