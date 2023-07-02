package org.ntananh.jarser;

public class ParserCombinatorReference<T> implements ParserCombinator<T> {

    private ParserCombinator<T> combinator;

    public void setCombinator(ParserCombinator<T> combinator) {
        this.combinator = combinator;
    }

    @Override
    public Result<T> apply(String input) {
        return combinator.apply(input);
    }
}
