package org.ntananh.jarser;

import java.util.Optional;

public class ParserCombinatorOptional<T> implements ParserCombinator<Optional<T>> {

    private final ParserCombinator<T> combinator;

    public ParserCombinatorOptional(ParserCombinator<T> combinator) {
        this.combinator = combinator;
    }

    @Override
    public Result<Optional<T>> apply(String input) {
        Result<T> result = combinator.apply(input);

        if (result.isAccepted()) {
            return new Accept<>(Optional.of(result.result()), result.remainingInput());
        } else {
            return new Accept<>(Optional.empty(), input);
        }
    }
}
