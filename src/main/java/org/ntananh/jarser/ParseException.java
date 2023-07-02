package org.ntananh.jarser;


/**
 * Signals a failed parse.
 */
public class ParseException extends RuntimeException {

    ParseException(String message) {
        super(message);
    }
}
