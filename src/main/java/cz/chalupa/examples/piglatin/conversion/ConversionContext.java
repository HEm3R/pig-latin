package cz.chalupa.examples.piglatin.conversion;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConversionContext {

    @NonNull private final SimpleConversionStrategy simpleStrategy;
    @NonNull private final HyphenConversionStrategy hyphenStrategy;

    public String convert(String input) {
        return hyphenStrategy.isHyphen(input) ? hyphenStrategy.convert(input) : simpleStrategy.convert(input);
    }
}
