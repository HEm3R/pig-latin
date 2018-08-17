package cz.chalupa.examples.piglatin.steps;

import com.codepoetics.protonpack.StreamUtils;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ApplyOriginalUpperCaseStep implements Step {

    @Override
    public StepInput convert(@NonNull StepInput input) {
        String output = StreamUtils.zipWithIndex(input.getValue().codePoints().mapToObj(cp -> (char) cp))
                .map(i -> input.getMetadata().getUpperCasePositions().contains(i.getIndex()) ? Character.toUpperCase(i.getValue()) : i.getValue())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return StepInput.builder().value(output).metadata(input.getMetadata()).build();
    }
}
