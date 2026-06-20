package pl.pjatk.piobed.handler;

import org.junit.jupiter.api.Test;
import pl.pjatk.piobed.configuration.AppProperties;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeServiceTest {

    @Test
    void shouldReturnDevWhenEnvironmentIsEmpty() {
        AppProperties appProperties = new AppProperties();
        appProperties.setEnvironment(null);

        FacadeService facadeService = new FacadeService(appProperties, List.of(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService()
        ));

        assertEquals("Hello from Dev", facadeService.execute());
    }

    @Test
    void shouldReturnStagingMessage() {
        AppProperties appProperties = new AppProperties();
        appProperties.setEnvironment("STAGING");

        FacadeService facadeService = new FacadeService(appProperties, List.of(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService()
        ));

        assertEquals("Hello from Staging", facadeService.execute());
    }
}
