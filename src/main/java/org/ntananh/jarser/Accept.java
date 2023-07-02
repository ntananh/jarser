package org.ntananh.jarser;

public class Accept<T> implements Result<T> {

    private final T result;
    private final String remainingInput;

    public Accept(T result, String remainingInput) {
        this.result = result;
        this.remainingInput = remainingInput;
    }

    @Override
    public boolean isAccepted() {
        return true;
    }

    @Override
    public T result() {
        return result;
    }

    @Override
    public String remainingInput() {
        return remainingInput;
    }

    @Override
    public String errorMessage() {
        throw new IllegalStateException();
    }
}
