package org.ntananh.jarser;

import java.util.function.Function;

public class ParserCombinatorMap<T, R> implements ParserCombinator<R> {

    private final ParserCombinator<T> combinator;
    private final Function<T, R> mapping;

    public ParserCombinatorMap(ParserCombinator<T> combinator, Function<T, R> mapping) {
        this.combinator = combinator;
        this.mapping = mapping;
    }

    @Override
    public Result<R> apply(String input) {
        Result<T> result = combinator.apply(input);

        if (result.isAccepted()) {
            return new Accept<>(mapping.apply(result.result()), result.remainingInput());
        } else {
            return new Reject<>(result.errorMessage());
        }
    }
}
