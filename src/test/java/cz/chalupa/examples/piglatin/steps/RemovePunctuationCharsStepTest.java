package cz.chalupa.examples.piglatin.steps;

import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemovePunctuationCharsStepTest {

    @Test
    void shouldRemovePunctuationByMetadata() {
        RemovePunctuationCharsStep step = new RemovePunctuationCharsStep();

        TreeMap<Long, Character> punctuationsFromEnd = new TreeMap<>();
        punctuationsFromEnd.put(16L, '_');
        punctuationsFromEnd.put(14L, '\'');
        punctuationsFromEnd.put(12L, '’');
        punctuationsFromEnd.put(10L, '"');
        punctuationsFromEnd.put(8L, '?');
        punctuationsFromEnd.put(6L, '!');
        punctuationsFromEnd.put(4L, '.');
        punctuationsFromEnd.put(2L, ',');
        punctuationsFromEnd.put(0L, ';');

        String value = "_A'B’C\"D?E!F.G,H;";
        StepInput input = StepInput.builder().value(value).metadata(StepInput.Metadata.builder().punctuationsFromEnd(punctuationsFromEnd).build()).build();
        assertThat(step.convert(input).getValue()).isEqualTo("ABCDEFGH");
    }
}
