package cz.chalupa.examples.piglatin.conversion;

import cz.chalupa.examples.piglatin.steps.ApplyOriginalPunctuationCharsStep;
import cz.chalupa.examples.piglatin.steps.ApplyOriginalUpperCaseStep;
import cz.chalupa.examples.piglatin.steps.ConversionStep;
import cz.chalupa.examples.piglatin.steps.FindPunctuationCharsStep;
import cz.chalupa.examples.piglatin.steps.FindUpperCaseCharsStep;
import cz.chalupa.examples.piglatin.steps.RemovePunctuationCharsStep;
import cz.chalupa.examples.piglatin.steps.StepInput;
import cz.chalupa.examples.piglatin.steps.ToLowerCaseStep;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SimpleConversionStrategy implements ConversionStrategy {

    @NonNull private final FindUpperCaseCharsStep findUpperCaseCharsStep;
    @NonNull private final FindPunctuationCharsStep findPunctuationCharsStep;
    @NonNull private final RemovePunctuationCharsStep removePunctuationCharsStep;
    @NonNull private final ToLowerCaseStep toLowerCaseStep;
    @NonNull private final ConversionStep conversionStep;
    @NonNull private final ApplyOriginalUpperCaseStep applyOriginalUpperCaseStep;
    @NonNull private final ApplyOriginalPunctuationCharsStep applyOriginalPunctuationCharsStep;

    @Override
    public String convert(String input) {
        StepInput init = StepInput.builder().value(input).metadata(StepInput.Metadata.builder().build()).build();

        StepInput upperCaseFound = findUpperCaseCharsStep.convert(init);
        StepInput punctuationFound = findPunctuationCharsStep.convert(upperCaseFound);
        StepInput punctuationRemoved = removePunctuationCharsStep.convert(punctuationFound);
        StepInput lower = toLowerCaseStep.convert(punctuationRemoved);
        StepInput converted = conversionStep.convert(lower);
        StepInput originalUpperCaseApplied = applyOriginalUpperCaseStep.convert(converted);
        StepInput originalPunctuationApplied = applyOriginalPunctuationCharsStep.convert(originalUpperCaseApplied);

        return originalPunctuationApplied.getValue();
    }
}
