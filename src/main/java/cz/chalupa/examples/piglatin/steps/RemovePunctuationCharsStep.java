package cz.chalupa.examples.piglatin.steps;

import java.util.stream.Stream;

import com.codepoetics.protonpack.StreamUtils;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class RemovePunctuationCharsStep implements Step {

    @Override
    public StepInput convert(@NonNull StepInput input) {
        StringBuilder reversed = new StringBuilder(input.getValue()).reverse();
        StringBuilder output = StreamUtils.zipWithIndex(reversed.codePoints().mapToObj(cp -> (char) cp))
                .flatMap(i -> input.getMetadata().getPunctuationsFromEnd().containsKey(i.getIndex()) ? Stream.empty() : Stream.of(i.getValue()))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
        return StepInput.builder().value(output.reverse().toString()).metadata(input.getMetadata()).build();
    }
}
