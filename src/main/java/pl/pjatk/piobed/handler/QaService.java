package pl.pjatk.piobed.handler;

import org.springframework.stereotype.Service;

/** Implementacja dla środowiska QA - uruchamiana z profilem qa (application-qa.yml). */
@Service
public class QaService implements HandlerServiceInterface {

    @Override
    public String getEnvironment() {
        return "QA";
    }

    @Override
    public String getMessage() {
        return "Hello from QA";
    }
}
