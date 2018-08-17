package cz.chalupa.examples.piglatin.steps;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConversionStepTest {

    private static final ConversionStep STEP = new ConversionStep();

    @Test
    void shouldKeepWordEndingWithWayAsIs() {
        assertThat(STEP.convert("stairway")).isEqualTo("stairway");
        assertThat(STEP.convert("airway")).isEqualTo("airway");
    }

    @Test
    void shouldAddWaySuffixToWordStartingWithVowel() {
        assertThat(STEP.convert("apple")).isEqualTo("appleway");
        assertThat(STEP.convert("orange")).isEqualTo("orangeway");
    }

    @Test
    void shouldMoveFirstLetterToEndAddAySuffixToWordStartingWithConsonant() {
        assertThat(STEP.convert("hello")).isEqualTo("ellohay");
        assertThat(STEP.convert("beach")).isEqualTo("eachbay");
    }
}
