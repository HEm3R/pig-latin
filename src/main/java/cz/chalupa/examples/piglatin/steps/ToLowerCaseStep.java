package cz.chalupa.examples.piglatin.steps;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ToLowerCaseStep implements Step {

    @Override
    public StepInput convert(@NonNull StepInput input) {
        return StepInput.builder().value(input.getValue().toLowerCase()).metadata(input.getMetadata()).build();
    }
}
