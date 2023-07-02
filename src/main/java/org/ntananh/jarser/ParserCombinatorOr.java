package org.ntananh.jarser;

public class ParserCombinatorOr<T> implements ParserCombinator<T> {

    private final ParserCombinator<T> combinator;
    private final ParserCombinator<T> or;

    ParserCombinatorOr(ParserCombinator<T> combinator, ParserCombinator<T> or) {
        this.combinator = combinator;
        this.or = or;
    }

    @Override
    public Result<T> apply(String input) {
        Result<T> result = combinator.apply(input);
        return result.isAccepted() ? result : or.apply(input);
    }
}
