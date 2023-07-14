package org.ntananh.jarser;

import java.util.ArrayList;
import java.util.List;

public class ParserCombinatorMany<T> implements ParserCombinator<List<T>> {

    private final ParserCombinator<T> combinator;

    public ParserCombinatorMany(ParserCombinator<T> combinator) {
        this.combinator = combinator;
    }

    @Override
    public Result<List<T>> apply(String input) {
        List<T> results = new ArrayList<>();
        for (Result<T> r = combinator.apply(input); r.isAccepted(); r = combinator.apply(input)) {
            results.add(r.result());
            input = r.remainingInput();
        }

        return new Accept<>(results, input);
    }
}
