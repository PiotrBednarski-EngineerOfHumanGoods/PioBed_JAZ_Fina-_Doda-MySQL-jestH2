package pl.pjatk.piobed.zjazd2.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.piobed.zjazd2.config.AppConfigurationProperties;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeServiceTest {

    @Test
    void shouldReturnDevByDefault() {
        AppConfigurationProperties properties = new AppConfigurationProperties();
        properties.setEnvironment(null);

        FacadeService facadeService = new FacadeService(properties, List.of(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService()
        ));

        assertEquals("Hello from Dev", facadeService.execute());
    }

    @Test
    void shouldReturnStagingMessage() {
        AppConfigurationProperties properties = new AppConfigurationProperties();
        properties.setEnvironment("STAGING");

        FacadeService facadeService = new FacadeService(properties, List.of(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService()
        ));

        assertEquals("Hello from Staging", facadeService.execute());
    }
}
