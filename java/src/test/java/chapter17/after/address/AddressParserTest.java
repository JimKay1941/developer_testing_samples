package chapter17.after.address;

import chapter17.address.AddressParser;
import chapter17.address.domain.ParsedAddress;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Shows how explanatory variables can be used to clarify a test.
 */
public class AddressParserTest {

    private AddressParser addressParser = new AddressParser();

    @Test
    public void parse_simpleMisspellingsAreTolerated() {
        String misspelledStreetAddress = "Sesame streat 123";
        int toleratedNumberOfErrors = 1;
        ParsedAddress address =
                addressParser.parse(misspelledStreetAddress,
                        toleratedNumberOfErrors);
        assertEquals("Sesame street", address.streetName);
    }

}
