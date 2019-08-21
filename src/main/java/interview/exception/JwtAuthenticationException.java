package interview.exception;

public class JwtAuthenticationException extends RuntimeException {

    private int status;
    private String url;
    private String message;

    public JwtAuthenticationException(String message) {
        super(message);
    }

    public JwtAuthenticationException(int status, String url, String message) {
        this.status = status;
        this.url = url;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
