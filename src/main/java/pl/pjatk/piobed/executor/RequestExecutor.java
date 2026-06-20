package pl.pjatk.piobed.executor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pjatk.piobed.configuration.AppProperties;
import pl.pjatk.piobed.handler.FacadeService;

/**
 * Komponent uruchamiany automatycznie zaraz po starcie aplikacji.
 *
 * Implementuje interfejs CommandLineRunner z Spring Boot - jego metoda run(args)
 * jest wywoływana po zainicjalizowaniu kontekstu Springa, a przed gotowością aplikacji
 * do obsługi requestów HTTP.
 *
 * Tutaj wypisujemy do konsoli aktualny profil i wynik z FacadeService - dzięki temu
 * widać, która implementacja HandlerServiceInterface została wybrana.
 */
@Component
public class RequestExecutor implements CommandLineRunner {

    private final FacadeService facadeService;
    private final AppProperties appProperties;

    public RequestExecutor(FacadeService facadeService, AppProperties appProperties) {
        this.facadeService = facadeService;
        this.appProperties = appProperties;
    }

    @Override
    public void run(String... args) {
        System.out.println("Environment: " + appProperties.getEnvironment());
        System.out.println("Owner: " + appProperties.getOwner().getName());
        System.out.println("Facade result: " + facadeService.execute());
    }
}
