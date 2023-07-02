package org.ntananh.jarser;


/**
 * Parse result returned by a {@code ParserCombinator}
 *
 * @param <T> type of the actual result object (e.g. a String )
 */
public interface Result<T> {

    /**
     * @return true, if input was accepted, false otherwise
     */
    boolean isAccepted();

    /**
     * @return parse result, if input was accepted throws Exception otherwise
     */
    T result();

    /**
     * @return remaining input,  if input was accepted, throw Exception otherwise
     */
    String remainingInput();


    /**
     * @return error message, if input was rejected, throw Exception otherwise
     */
    String errorMessage();

}
