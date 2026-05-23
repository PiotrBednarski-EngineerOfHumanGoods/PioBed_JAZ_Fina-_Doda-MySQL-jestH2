package pl.pjatk.piobed.zjazd2.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pjatk.piobed.zjazd2.config.AppConfigurationProperties;

@Component
public class RequestExecutor implements CommandLineRunner {

    private final FacadeService facadeService;
    private final AppConfigurationProperties configurationProperties;

    public RequestExecutor(FacadeService facadeService,
                           AppConfigurationProperties configurationProperties) {
        this.facadeService = facadeService;
        this.configurationProperties = configurationProperties;
    }

    @Override
    public void run(String... args) {
        System.out.println("Environment: " + configurationProperties.getEnvironment());
        System.out.println("Owner: " + configurationProperties.getOwner().getName());
        System.out.println("Facade result: " + facadeService.execute());
    }
}
