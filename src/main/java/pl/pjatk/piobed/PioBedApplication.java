package pl.pjatk.piobed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import pl.pjatk.piobed.configuration.AppProperties;

/**
 * Punkt startowy aplikacji Spring Boot - MovieService.
 *
 * Adnotacje:
 *   - @SpringBootApplication   - włącza autokonfigurację Springa i skan komponentów
 *                                w tym pakiecie i podpakietach (@ComponentScan).
 *   - @EnableConfigurationProperties(AppProperties.class) - rejestruje klasę typowych
 *                                propertiesów wczytywanych z application.yml (prefix "app.").
 *   - @ImportResource("classpath:beans.xml") - dołącza beany zdefiniowane w XML-u
 *                                (xmlFirstComponent, xmlSecondComponent).
 *
 * Klasa zawiera metodę main, którą uruchamiamy aplikację.
 */
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@ImportResource("classpath:beans.xml")
public class PioBedApplication {

    public static void main(String[] args) {
        SpringApplication.run(PioBedApplication.class, args);
    }
}
