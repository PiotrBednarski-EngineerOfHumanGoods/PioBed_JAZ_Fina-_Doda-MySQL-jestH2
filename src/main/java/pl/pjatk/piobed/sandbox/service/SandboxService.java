package pl.pjatk.piobed.sandbox.service;

import org.springframework.stereotype.Service;

/**
 * Serwis pomocniczy dla ćwiczenia 1 ze zjazdu 4 - rzuca wyjątek RuntimeException,
 * który jest następnie łapany przez @RestControllerAdvice w GlobalExceptionHandler.
 *
 * To realizacja zasady z ćwiczenia 2 zjazdu 4 - "logika biznesowa ma się znaleźć
 * w klasach z @Service, a kontroler ma tylko deklarować endpoint i delegować
 * pracę do serwisu (z wstrzykiwaniem przez konstruktor)".
 */
@Service
public class SandboxService {

    public String throwException() {
        throw new RuntimeException("Exception from SandboxService");
    }
}
