package cz.chalupa.examples.piglatin.steps;

import java.util.Arrays;
import java.util.List;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ConversionStep implements Step {

    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');

    private static final String VOWEL_SUFFIX = "way";
    private static final String CONSONANT_SUFFIX = "ay";

    @Override
    public StepInput convert(@NonNull StepInput input) {
        if (input.getValue().isEmpty() || input.getValue().endsWith("way")) {
            return input;
        }
        char first = input.getValue().charAt(0);
        String converted = VOWELS.stream().anyMatch(v -> v == first) ? convertVowel(input.getValue()) : convertConsonant(input.getValue());
        return StepInput.builder().value(converted).metadata(input.getMetadata()).build();
    }

    private String convertVowel(String input) {
        return input + VOWEL_SUFFIX;
    }

    private String convertConsonant(String input) {
        String firstLetter = input.substring(0, 1);
        return input.substring(1) + firstLetter + CONSONANT_SUFFIX;
    }
}
