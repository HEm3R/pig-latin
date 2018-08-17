package cz.chalupa.examples.piglatin.conversion;

import org.springframework.stereotype.Component;

@Component
public class SimpleConversionStrategy implements ConversionStrategy {

    @Override
    public String convert(String input) {
        return "[convert]" + input; // TODO: do real conversion
    }
}
