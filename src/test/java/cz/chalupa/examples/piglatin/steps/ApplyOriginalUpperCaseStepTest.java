package cz.chalupa.examples.piglatin.steps;

import java.util.HashSet;

import cz.chalupa.examples.piglatin.steps.StepInput.Metadata;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class ApplyOriginalUpperCaseStepTest {

    @Test
    void shouldApplyUpperCase() {
        ApplyOriginalUpperCaseStep step = new ApplyOriginalUpperCaseStep();

        assertThat(step.convert(input("beach", 0L)).getValue()).isEqualTo("Beach");
        assertThat(step.convert(input("mccloud", 0L, 2L)).getValue()).isEqualTo("McCloud");
        assertThat(step.convert(input("test", 2L, 3L)).getValue()).isEqualTo("teST");
    }

    private StepInput input(String input, Long... upperCasePositions) {
        return StepInput.builder().value(input).metadata(Metadata.builder().upperCasePositions(new HashSet<>(asList(upperCasePositions))).build()).build();
    }
}
