package cz.chalupa.examples.piglatin.steps;

import java.util.Set;
import java.util.stream.Collectors;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class FindUpperCaseCharsStep implements Step {

    @Override
    public StepInput convert(@NonNull StepInput input) {
        Set<Long> positions = StreamUtils.zipWithIndex(input.getValue().codePoints().mapToObj(cp -> (char) cp))
                .filter(i -> Character.isUpperCase(i.getValue()))
                .map(Indexed::getIndex)
                .collect(Collectors.toSet());
        return StepInput.builder().value(input.getValue()).metadata(StepInput.Metadata.builder().upperCasePositions(positions).build()).build();
    }
}
