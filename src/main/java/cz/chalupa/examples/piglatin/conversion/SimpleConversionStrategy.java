package cz.chalupa.examples.piglatin.conversion;

import cz.chalupa.examples.piglatin.steps.ApplyOriginalUpperCaseStep;
import cz.chalupa.examples.piglatin.steps.ConversionStep;
import cz.chalupa.examples.piglatin.steps.FindUpperCaseCharsStep;
import cz.chalupa.examples.piglatin.steps.StepInput;
import cz.chalupa.examples.piglatin.steps.ToLowerCaseStep;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SimpleConversionStrategy implements ConversionStrategy {

    @NonNull private final FindUpperCaseCharsStep findUpperCaseCharsStep;
    @NonNull private final ToLowerCaseStep toLowerCaseStep;
    @NonNull private final ConversionStep conversionStep;
    @NonNull private final ApplyOriginalUpperCaseStep applyOriginalUpperCaseStep;

    @Override
    public String convert(String input) {
        StepInput init = StepInput.builder().value(input).metadata(StepInput.Metadata.builder().build()).build();

        StepInput upperCaseFound = findUpperCaseCharsStep.convert(init);
        StepInput lower = toLowerCaseStep.convert(upperCaseFound);
        StepInput converted = conversionStep.convert(lower);
        StepInput originalUpperCaseApplied = applyOriginalUpperCaseStep.convert(converted);

        return originalUpperCaseApplied.getValue();
    }
}
