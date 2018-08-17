package cz.chalupa.examples.piglatin.steps;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.codepoetics.protonpack.StreamUtils;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class FindUpperCaseCharsStep implements Step {

    @Override
    public StepInput convert(@NonNull StepInput input) {
        Set<Long> positions = StreamUtils.zipWithIndex(input.getValue().codePoints().mapToObj(cp -> (char) cp))
                .flatMap(i -> Character.isUpperCase(i.getValue()) ? Stream.of(i.getIndex()) : Stream.empty())
                .collect(Collectors.toSet());
        return StepInput.builder().value(input.getValue()).metadata(StepInput.Metadata.builder().upperCasePositions(positions).build()).build();
    }
}
