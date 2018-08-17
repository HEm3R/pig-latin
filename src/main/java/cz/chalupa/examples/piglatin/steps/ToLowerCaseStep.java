package cz.chalupa.examples.piglatin.steps;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ToLowerCaseStep implements Step {

    @Override
    public String convert(@NonNull String input) {
        return input.toLowerCase();
    }
}
