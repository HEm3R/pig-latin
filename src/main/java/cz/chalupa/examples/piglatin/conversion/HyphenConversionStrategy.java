package cz.chalupa.examples.piglatin.conversion;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HyphenConversionStrategy implements ConversionStrategy {

    private static final String DELIMITER = "-";

    @NonNull private final SimpleConversionStrategy delegate;

    @Override
    public String convert(String input) {
        List<Object> tokens = Collections.list(new StringTokenizer(input, DELIMITER));
        return tokens.stream().map(t -> (String) t).map(delegate::convert).collect(Collectors.joining(DELIMITER));
    }

    boolean isHyphen(@NonNull String input) {
        return input.contains(DELIMITER);
    }
}
