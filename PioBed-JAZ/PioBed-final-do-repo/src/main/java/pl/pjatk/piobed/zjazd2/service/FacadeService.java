package pl.pjatk.piobed.zjazd2.service;

import org.springframework.stereotype.Service;
import pl.pjatk.piobed.zjazd2.config.AppConfigurationProperties;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FacadeService {

    private final AppConfigurationProperties configurationProperties;
    private final Map<String, HandlerServiceInterface> services;

    public FacadeService(AppConfigurationProperties configurationProperties,
                         List<HandlerServiceInterface> services) {
        this.configurationProperties = configurationProperties;
        this.services = services.stream()
                .collect(Collectors.toMap(HandlerServiceInterface::getEnvironment, Function.identity()));
    }

    public String execute() {
        String environment = configurationProperties.getEnvironment();

        if (environment == null || environment.isBlank()) {
            environment = "DEV";
        }

        HandlerServiceInterface selectedService = services.get(environment.toUpperCase());

        if (selectedService == null) {
            selectedService = services.get("DEV");
        }

        return selectedService.getMessage();
    }
}
