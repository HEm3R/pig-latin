package cz.chalupa.examples.piglatin.steps;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindUpperCaseCharsStepTest {

    @Test
    void shouldFindAllUpperCases() {
        FindUpperCaseCharsStep step = new FindUpperCaseCharsStep();

        assertThat(step.convert(input("Beach")).getMetadata().getUpperCasePositions()).containsExactly(0L);
        assertThat(step.convert(input("McCloud")).getMetadata().getUpperCasePositions()).containsExactly(0L, 2L);
        assertThat(step.convert(input("teST")).getMetadata().getUpperCasePositions()).containsExactly(2L, 3L);
    }

    private StepInput input(String input) {
        return StepInput.builder().value(input).metadata(StepInput.Metadata.builder().build()).build();
    }
}
