package kz.onggar.collector.exception;

public class AlreadyExistException extends CustomException {
    public AlreadyExistException(String shortMessage) {
        super(shortMessage);
    }
}
