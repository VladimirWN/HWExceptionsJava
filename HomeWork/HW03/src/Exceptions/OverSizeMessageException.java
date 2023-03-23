package Exceptions;

public class OverSizeMessageException extends RuntimeException {
    public OverSizeMessageException(String message) {
        super(message);
    }
}
