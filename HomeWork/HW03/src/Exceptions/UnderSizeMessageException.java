package Exceptions;

public class UnderSizeMessageException extends RuntimeException {
    public UnderSizeMessageException(String message) {
        super(message);
    }
}
