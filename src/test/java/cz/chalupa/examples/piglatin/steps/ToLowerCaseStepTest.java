package cz.chalupa.examples.piglatin.steps;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToLowerCaseStepTest {

    @Test
    void shouldConvertInputToLowerCase() {
        ToLowerCaseStep step = new ToLowerCaseStep();

        assertThat(step.convert("Lower")).isEqualTo("lower");
        assertThat(step.convert("CASE")).isEqualTo("case");
        assertThat(step.convert("sTeP")).isEqualTo("step");
    }
}
