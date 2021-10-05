package kz.onggar.collector.exception;

public class CustomException extends RuntimeException {
    protected final String shortMessage;

    public CustomException(String message, String shortMessage) {
        super(message);
        this.shortMessage = shortMessage;
    }

    public CustomException(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getShortMessage() {
        return shortMessage;
    }
}
