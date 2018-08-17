package cz.chalupa.examples.piglatin.steps;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConversionStepTest {

    private static final ConversionStep STEP = new ConversionStep();

    @Test
    void shouldKeepWordEndingWithWayAsIs() {
        assertThat(STEP.convert(input("stairway")).getValue()).isEqualTo("stairway");
        assertThat(STEP.convert(input("airway")).getValue()).isEqualTo("airway");
    }

    @Test
    void shouldAddWaySuffixToWordStartingWithVowel() {
        assertThat(STEP.convert(input("apple")).getValue()).isEqualTo("appleway");
        assertThat(STEP.convert(input("orange")).getValue()).isEqualTo("orangeway");
    }

    @Test
    void shouldMoveFirstLetterToEndAddAySuffixToWordStartingWithConsonant() {
        assertThat(STEP.convert(input("hello")).getValue()).isEqualTo("ellohay");
        assertThat(STEP.convert(input("beach")).getValue()).isEqualTo("eachbay");
    }

    private StepInput input(String input) {
        return StepInput.builder().value(input).metadata(StepInput.Metadata.builder().build()).build();
    }
}
