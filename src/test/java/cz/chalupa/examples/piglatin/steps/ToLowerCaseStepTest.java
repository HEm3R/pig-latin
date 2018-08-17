package cz.chalupa.examples.piglatin.steps;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToLowerCaseStepTest {

    @Test
    void shouldConvertInputToLowerCase() {
        ToLowerCaseStep step = new ToLowerCaseStep();

        assertThat(step.convert(input("Lower")).getValue()).isEqualTo("lower");
        assertThat(step.convert(input("CASE")).getValue()).isEqualTo("case");
        assertThat(step.convert(input("sTeP")).getValue()).isEqualTo("step");
    }

    private StepInput input(String input) {
        return StepInput.builder().value(input).metadata(StepInput.Metadata.builder().build()).build();
    }
}
