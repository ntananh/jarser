package org.ntananh.jarser;

import org.junit.Test;

import java.util.*;

import static java.util.Collections.*;
import static junit.framework.TestCase.assertEquals;

public class ParserCombinatorTest {

    private final ParserCombinator<String> foo = ParserCombinators.string("foo");
    private final ParserCombinator<String> bar = ParserCombinators.string("bar");

    private final Parser<Optional<String>> fooOptionalParser = foo.optional().end();

    private final Parser<String> fooOrBarParser = foo.or(bar).end();
    private final Parser<List<String>> fooRepeatingParser = foo.many().end();
    private final Parser<String> fooParser = foo.end();

    @Test
    public void shouldParserConstantString() {
        assertEquals("foo", fooParser.apply("foo"));
    }

    @Test(expected = ParseException.class)
    public void shouldNotParseWrongConstant() {
        fooParser.apply("bar");
    }

    @Test
    public void shouldParserOptionalConstant() {
        assertEquals(Optional.of("foo"), fooOptionalParser.apply("foo"));
        assertEquals(Optional.empty(), fooOptionalParser.apply(""));
    }

    @Test
    public void shouldParseAnyPossibleConstant() {
        assertEquals("foo", fooOrBarParser.apply("foo"));
        assertEquals("bar", fooOrBarParser.apply("bar"));
    }

    @Test(expected = ParseException.class)
    public void shouldNotParseImpossibleConstants() {
        fooOrBarParser.apply("baz");
    }

    @Test(expected = ParseException.class)
    public void shouldNotPrefixOrSuffixConstants() {
        fooOrBarParser.apply("foobar");
    }

    @Test
    public void shouldParseRepeatedConstantWithZeroValues() {
        assertEquals(emptyList(), fooRepeatingParser.apply(""));
    }

    @Test
    public void shouldParseRepeatedConstantWithOneValue() {
        assertEquals(singletonList("foo"), fooRepeatingParser.apply("foo"));
    }

    @Test
    public void shouldParseRepeatedConstant() {
        assertEquals(Arrays.asList("foo", "foo","foo"), fooRepeatingParser.apply("foofoofoo"));
    }

}

