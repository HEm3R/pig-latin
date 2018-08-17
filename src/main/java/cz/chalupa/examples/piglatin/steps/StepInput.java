package cz.chalupa.examples.piglatin.steps;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class StepInput {

    @NonNull private final String value;
    @NonNull private final Metadata metadata;

    @Getter
    @Builder
    public static class Metadata {

        private Set<Long> upperCasePositions;
    }
}
