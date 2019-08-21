package interview.exception.response;

import java.util.Objects;

public final class ExceptionResponse {

    private int status;
    private String message;
    private String url;

    private ExceptionResponse(int status, String message, String url) {
        this.status = status;
        this.message = message;
        this.url = url;
    }

    public static ExceptionResponseBuilder getBuilder() {
        return new ExceptionResponseBuilder();
    }


    public static class ExceptionResponseBuilder {

        private int status;
        private String message;
        private String url;

        public ExceptionResponseBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ExceptionResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ExceptionResponseBuilder url(String url) {
            this.url = url;
            return this;
        }

        public ExceptionResponse build() {
            return new ExceptionResponse(status, message, url);
        }
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }


    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "status=" + status +
                ", url='" + url + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExceptionResponse)) return false;
        ExceptionResponse that = (ExceptionResponse) o;
        return status == that.status &&
                Objects.equals(url, that.url) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, url, message);
    }
}
