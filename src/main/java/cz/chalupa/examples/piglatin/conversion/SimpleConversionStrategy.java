package cz.chalupa.examples.piglatin.conversion;

import cz.chalupa.examples.piglatin.steps.ConversionStep;
import cz.chalupa.examples.piglatin.steps.ToLowerCaseStep;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SimpleConversionStrategy implements ConversionStrategy {

    @NonNull private final ToLowerCaseStep toLowerCaseStep;
    @NonNull private final ConversionStep conversionStep;

    @Override
    public String convert(String input) {
        String lower = toLowerCaseStep.convert(input);
        return conversionStep.convert(lower);
    }
}
