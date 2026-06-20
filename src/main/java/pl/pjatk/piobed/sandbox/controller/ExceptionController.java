package pl.pjatk.piobed.sandbox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.piobed.sandbox.service.SandboxService;

/**
 * Ćwiczenie 1 ze zjazdu 4.
 *
 * Treść zadania:
 *   "Dodaj nowy endpoint /excpetion, który po wywołaniu go będzie rzucać dowolny
 *    exception (RuntimeException, NullPointerException, etc.). Dodaj
 *    @RestControllerAdvice który obsłuży ten błąd i pozwoli nam zwrócić status 400
 *    oraz body 'Exception occurred on request. Exception message: ' + treść_błędu."
 *
 * Wyjątek jest rzucany w SandboxService, a obsługiwany w
 * advice/GlobalExceptionHandler (klasa z adnotacją @RestControllerAdvice).
 *
 * Uwaga: literówka "excpetion" jest celowa - taką dokładnie ścieżkę podał prowadzący
 * na slajdzie.
 */
@RestController
public class ExceptionController {

    private final SandboxService sandboxService;

    public ExceptionController(SandboxService sandboxService) {
        this.sandboxService = sandboxService;
    }

    @GetMapping("/excpetion")
    public String exceptionFromExercise() {
        return sandboxService.throwException();
    }
}
