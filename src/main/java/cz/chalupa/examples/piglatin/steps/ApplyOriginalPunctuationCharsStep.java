package cz.chalupa.examples.piglatin.steps;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ApplyOriginalPunctuationCharsStep implements Step {

    @Override
    public StepInput convert(@NonNull StepInput input) {
        StringBuilder sb = new StringBuilder(input.getValue()).reverse();
        input.getMetadata().getPunctuationsFromEnd().forEach((key, value) -> sb.insert(key.intValue(), value));
        return StepInput.builder().value(sb.reverse().toString()).metadata(input.getMetadata()).build();
    }
}
