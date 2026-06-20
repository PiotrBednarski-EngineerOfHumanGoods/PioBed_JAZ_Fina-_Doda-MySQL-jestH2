package pl.pjatk.piobed.handler;

import org.springframework.stereotype.Service;

/**
 * Implementacja dla środowiska STAGING - profil "staging" (gdyby dorobić application-staging.yml).
 * Środowisko można też wymusić w application.yml polem app.environment: STAGING.
 */
@Service
public class StagingService implements HandlerServiceInterface {

    @Override
    public String getEnvironment() {
        return "STAGING";
    }

    @Override
    public String getMessage() {
        return "Hello from Staging";
    }
}
