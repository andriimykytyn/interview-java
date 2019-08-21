package interview.exception.interceptor;

import interview.exception.DbOperationException;
import interview.exception.NotFoundException;
import interview.exception.RecordExistException;
import interview.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    protected ExceptionResponse handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        StringBuilder message = new StringBuilder();

        for (FieldError f:fieldErrors) {
            message.append(f.getField() + ": "+ f.getDefaultMessage() + "; ");
        }

        String errorMessage = message.toString();

        return ExceptionResponse.getBuilder()
                .status(HttpStatus.BAD_REQUEST.value())
                .url(request.getRequestURI())
                .message(errorMessage)

                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ DbOperationException.class })
    public ExceptionResponse handleDbOperation(DbOperationException ex, HttpServletRequest request) {

        String url = request.getRequestURI();
        String message = ex.getLocalizedMessage();

        return ExceptionResponse.getBuilder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .url(url)
                .message(message)
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NotFoundException.class })
    public ExceptionResponse handleNotFound(NotFoundException ex, HttpServletRequest request) {

        String url = request.getRequestURI();
        String message = ex.getLocalizedMessage();

        return ExceptionResponse.getBuilder()
                .status(HttpStatus.NOT_FOUND.value())
                .url(url)
                .message(message)
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({RecordExistException.class})
    public ExceptionResponse handleNotFound(RecordExistException ex, HttpServletRequest request) {

        String url = request.getRequestURI();
        String message = ex.getLocalizedMessage();

        return ExceptionResponse.getBuilder()
                .status(HttpStatus.CONFLICT.value())
                .url(url)
                .message(message)
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    public ExceptionResponse handleAll(Exception ex, HttpServletRequest request) {

        String url = request.getRequestURI();
        String message = ex.getLocalizedMessage();

        return ExceptionResponse.getBuilder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .url(url)
                .message(message)
                .build();
    }

}
