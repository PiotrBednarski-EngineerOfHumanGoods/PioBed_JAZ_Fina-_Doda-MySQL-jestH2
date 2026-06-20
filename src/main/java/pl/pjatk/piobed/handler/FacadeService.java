package pl.pjatk.piobed.handler;

import org.springframework.stereotype.Service;
import pl.pjatk.piobed.configuration.AppProperties;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Fasada wybierająca odpowiedni HandlerServiceInterface na podstawie aktywnego środowiska.
 *
 * Spring potrafi wstrzyknąć do konstruktora List<HandlerServiceInterface> - automatycznie
 * pakuje tam wszystkie beany implementujące ten interfejs (DevService, QaService,
 * StagingService, ProdService).
 *
 * W konstruktorze konwertujemy listę na mapę po kluczu "environment", żeby później
 * móc wybrać implementację w O(1).
 *
 * Wartość appProperties.getEnvironment() pochodzi z application.yml (app.environment),
 * domyślnie "DEV". Profile (application-dev.yml itd.) mogą ją nadpisać.
 */
@Service
public class FacadeService {

    private final AppProperties appProperties;
    private final Map<String, HandlerServiceInterface> services;

    public FacadeService(AppProperties appProperties, List<HandlerServiceInterface> services) {
        this.appProperties = appProperties;
        this.services = services.stream()
                .collect(Collectors.toMap(HandlerServiceInterface::getEnvironment, Function.identity()));
    }

    public String execute() {
        String environment = appProperties.getEnvironment();

        // Gdy properties nie podaje środowiska - fallback na DEV.
        if (environment == null || environment.isBlank()) {
            environment = "DEV";
        }

        HandlerServiceInterface selectedService = services.get(environment.toUpperCase());

        // Jeśli skonfigurowane środowisko nie ma swojej implementacji - bierzemy DEV.
        if (selectedService == null) {
            selectedService = services.get("DEV");
        }

        return selectedService.getMessage();
    }
}
