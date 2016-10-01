package chapter17.address;


import chapter17.address.domain.ParsedAddress;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This is just a stub to make the tests compile.
 */
public class AddressParser {

    public ParsedAddress parse(String address, int misspellings) {

        // Complex logic that would match street names with a database of
        // existing streets. This implementation just makes the test pass.
        ParsedAddress parsedAddress = new ParsedAddress();
        parsedAddress.streetName = Arrays.stream(address.split(" "))
                .filter(s->s.matches("[a-zA-Z]+"))
                .map(s->s.replace("streat", "street"))
                .collect(Collectors.joining(" "));
        return parsedAddress;
    }
}
