package pl.pjatk.piobed.zjazd4.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
        String body = "Exception occurred on request. Exception message: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
