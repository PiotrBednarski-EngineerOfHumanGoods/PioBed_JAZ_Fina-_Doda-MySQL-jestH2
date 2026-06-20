package pl.pjatk.piobed.component;

import org.springframework.stereotype.Component;

/**
 * Bean rejestrowany przez adnotację @Component - Spring sam go wykryje przez
 * @ComponentScan (uruchamiany domyślnie przez @SpringBootApplication).
 *
 * Spring tworzy ten obiekt jako singleton (domyślny scope) - jeden raz przy starcie
 * aplikacji - dlatego komunikat z konstruktora pokazuje się tylko raz w logu.
 */
@Component
public class MyFirstComponent {

    public MyFirstComponent() {
        System.out.println("Hello from MyFirstComponent");
    }

    public void printFirstMessage() {
        System.out.println("MyFirstComponent - printFirstMessage");
    }
}
