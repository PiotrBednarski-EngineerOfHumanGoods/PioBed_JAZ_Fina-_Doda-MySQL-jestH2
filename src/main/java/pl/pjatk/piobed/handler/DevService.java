package pl.pjatk.piobed.handler;

import org.springframework.stereotype.Service;

/**
 * Implementacja HandlerServiceInterface dla środowiska DEV.
 * FacadeService wybiera tę implementację gdy app.environment = DEV (lub domyślnie).
 */
@Service
public class DevService implements HandlerServiceInterface {

    @Override
    public String getEnvironment() {
        return "DEV";
    }

    @Override
    public String getMessage() {
        return "Hello from Dev";
    }
}
