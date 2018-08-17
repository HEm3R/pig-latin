package cz.chalupa.examples.piglatin.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HyphenConversionStrategyTest {

    @Mock private SimpleConversionStrategy delegate;

    private HyphenConversionStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new HyphenConversionStrategy(delegate);
    }

    @Test
    void shouldConvertHyphensByEachPart() {
        doReturn("[converted]hyphen").when(delegate).convert("hyphen");
        doReturn("[converted]word").when(delegate).convert("word");
        assertThat(strategy.convert("hyphen-word")).isEqualTo("[converted]hyphen-[converted]word");
    }

    @Test
    void shouldConvertMultiHyphensByEachPart() {
        doReturn("[converted]multi").when(delegate).convert("multi");
        doReturn("[converted]hyphen").when(delegate).convert("hyphen");
        doReturn("[converted]word").when(delegate).convert("word");
        assertThat(strategy.convert("multi-hyphen-word")).isEqualTo("[converted]multi-[converted]hyphen-[converted]word");
    }

    @Test
    void shouldConvertSimpleWords() {
        when(delegate.convert("simple")).thenReturn("[converted]simple");
        assertThat(strategy.convert("simple")).isEqualTo("[converted]simple");
    }
}
