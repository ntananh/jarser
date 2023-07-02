package org.ntananh.jarser;

import java.util.NoSuchElementException;

public class Reject<T> implements Result<T> {

    private String errorMessage;

    Reject(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean isAccepted() {
        return false;
    }

    @Override
    public T result() {
        throw new NoSuchElementException();
    }

    @Override
    public String remainingInput() {
        throw new IllegalStateException();
    }

    @Override
    public String errorMessage() {
        return errorMessage;
    }
}
