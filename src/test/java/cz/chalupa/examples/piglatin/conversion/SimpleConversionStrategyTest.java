package cz.chalupa.examples.piglatin.conversion;

import cz.chalupa.examples.piglatin.steps.ApplyOriginalPunctuationCharsStep;
import cz.chalupa.examples.piglatin.steps.ApplyOriginalUpperCaseStep;
import cz.chalupa.examples.piglatin.steps.ConversionStep;
import cz.chalupa.examples.piglatin.steps.FindPunctuationCharsStep;
import cz.chalupa.examples.piglatin.steps.FindUpperCaseCharsStep;
import cz.chalupa.examples.piglatin.steps.RemovePunctuationCharsStep;
import cz.chalupa.examples.piglatin.steps.ToLowerCaseStep;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConversionStrategyTest {

    @Test
    void shouldConvert() {
        SimpleConversionStrategy conversion = new SimpleConversionStrategy(
                new FindUpperCaseCharsStep(),
                new FindPunctuationCharsStep(),
                new RemovePunctuationCharsStep(),
                new ToLowerCaseStep(),
                new ConversionStep(),
                new ApplyOriginalUpperCaseStep(),
                new ApplyOriginalPunctuationCharsStep()
        );

        assertThat(conversion.convert("Hello")).isEqualTo("Ellohay");
        assertThat(conversion.convert("apple")).isEqualTo("appleway");
        assertThat(conversion.convert("stairway")).isEqualTo("stairway");
        assertThat(conversion.convert("can’t")).isEqualTo("antca’y");
        assertThat(conversion.convert("end.")).isEqualTo("endway.");
        assertThat(conversion.convert("Beach")).isEqualTo("Eachbay");
        assertThat(conversion.convert("McCloud")).isEqualTo("CcLoudmay");
    }
}
