package pl.pjatk.piobed.handler;

import org.springframework.stereotype.Service;

/** Implementacja dla środowiska PROD - uruchamiana z profilem prod (application-prod.yml). */
@Service
public class ProdService implements HandlerServiceInterface {

    @Override
    public String getEnvironment() {
        return "PROD";
    }

    @Override
    public String getMessage() {
        return "Hello from Prod";
    }
}
