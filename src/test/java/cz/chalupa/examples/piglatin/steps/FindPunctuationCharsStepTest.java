package cz.chalupa.examples.piglatin.steps;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindPunctuationCharsStepTest {

    @Test
    void shouldFindPunctuationWithPositionFromEnd() {
        FindPunctuationCharsStep step = new FindPunctuationCharsStep();

        String value = "_A'B’C\"D?E!F.G,H;";
        StepInput input = StepInput.builder().value(value).metadata(StepInput.Metadata.builder().build()).build();
        assertThat(step.convert(input).getMetadata().getPunctuationsFromEnd())
                .containsEntry(16L, '_')
                .containsEntry(14L, '\'')
                .containsEntry(12L, '’')
                .containsEntry(10L, '"')
                .containsEntry(8L, '?')
                .containsEntry(6L, '!')
                .containsEntry(4L, '.')
                .containsEntry(2L, ',')
                .containsEntry(0L, ';');
    }
}
