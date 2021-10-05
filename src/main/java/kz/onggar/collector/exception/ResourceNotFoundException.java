package kz.onggar.collector.exception;

public class ResourceNotFoundException extends CustomException {
    public ResourceNotFoundException(String shortMessage) {
        super(shortMessage);
    }
}
