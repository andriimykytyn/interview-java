package interview.exception;

public class DbOperationException extends RuntimeException {

    public DbOperationException(String message) {
        super(message);
    }
}
