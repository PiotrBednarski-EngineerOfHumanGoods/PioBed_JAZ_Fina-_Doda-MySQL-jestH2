package pl.pjatk.piobed.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Globalna obsługa wyjątków dla całej aplikacji.
 *
 * Adnotacja @RestControllerAdvice mówi Springowi, że klasa "podpina się" pod
 * wszystkie kontrolery REST i może łapać wyjątki rzucone z ich metod.
 *
 * Każda metoda oznaczona @ExceptionHandler(KlasaWyjątku.class) zostaje wywołana,
 * gdy w kontrolerze poleci dany wyjątek. Zamiast domyślnej odpowiedzi 500 dostajemy
 * zdefiniowaną tu odpowiedź - tutaj 400 BAD_REQUEST z ciałem zawierającym message.
 *
 * Zadanie ze zjazdu 4: dodać endpoint który rzuca wyjątek i obsłużyć go przez
 * @RestControllerAdvice (patrz: sandbox/controller/ExceptionController).
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
        String body = "Exception occurred on request. Exception message: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
