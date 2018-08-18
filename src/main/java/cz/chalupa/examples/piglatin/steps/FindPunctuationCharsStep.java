package cz.chalupa.examples.piglatin.steps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import cz.chalupa.examples.piglatin.steps.StepInput.Metadata;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class FindPunctuationCharsStep implements Step {

    private static final Set<Character> PUNCTUATIONS = new HashSet<>(Arrays.asList('_', '\'', '’', '"', '?', '!', '.', ',', ';'));

    @Override
    public StepInput convert(@NonNull StepInput input) {
        StringBuilder reversed = new StringBuilder(input.getValue()).reverse();
        TreeMap<Long, Character> punctuations = StreamUtils.zipWithIndex(reversed.codePoints().mapToObj(cp -> (char) cp))
                .filter(i -> PUNCTUATIONS.contains(i.getValue()))
                .collect(Collectors.toMap(Indexed::getIndex, Indexed::getValue, (u,v) -> u, TreeMap::new));

        return StepInput.builder().value(input.getValue()).metadata(
                Metadata.builder().upperCasePositions(input.getMetadata().getUpperCasePositions()).punctuationsFromEnd(punctuations).build()
        ).build();
    }
}
