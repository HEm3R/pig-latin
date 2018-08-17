package cz.chalupa.examples.piglatin.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConversionContextTest {

    @Mock private SimpleConversionStrategy simpleConversionStrategy;
    @Mock private HyphenConversionStrategy hyphenConversionStrategy;

    private ConversionContext context;

    @BeforeEach
    void setUp() {
        context = new ConversionContext(simpleConversionStrategy, hyphenConversionStrategy);
    }

    @Test
    void shouldSelectSimpleStrategyForNonHyphens() {
        String input = "simple";

        context.convert(input);

        verify(simpleConversionStrategy).convert(input);
        verify(hyphenConversionStrategy, never()).convert(input);
    }

    @Test
    void shouldSelectHyphenStrategyForHyphens() {
        String input = "hyphen-input";
        when(hyphenConversionStrategy.isHyphen(input)).thenReturn(true);

        context.convert(input);

        verify(hyphenConversionStrategy).convert(input);
        verify(simpleConversionStrategy, never()).convert(input);
    }
}
