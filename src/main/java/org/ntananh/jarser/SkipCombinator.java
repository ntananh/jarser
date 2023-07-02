package org.ntananh.jarser;

public class SkipCombinator {

    private final ParserCombinator<?> skip;


    public SkipCombinator(ParserCombinator<?> skip) {
        this.skip = skip;
    }

    public <T> ParserCombinator<T> next(ParserCombinator<T> next) {
        return input -> {
            Result<?> skipResult = skip.apply(input);

            if (skipResult.isAccepted()) {
                return next.apply(skipResult.remainingInput());
            } else {
                return new Reject<>(skipResult.errorMessage());
            }
        };
    }
}
