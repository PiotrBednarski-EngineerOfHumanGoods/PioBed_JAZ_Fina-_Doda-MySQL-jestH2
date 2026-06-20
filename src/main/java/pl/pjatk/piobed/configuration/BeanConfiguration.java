package pl.pjatk.piobed.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.piobed.pojo.SimplePojo;

import java.util.List;

/**
 * Klasa konfiguracyjna - rejestruje ręcznie tworzone beany.
 *
 * Adnotacja @Configuration mówi, że klasa zawiera definicje beanów. Każda metoda
 * oznaczona @Bean zwraca obiekt, który Spring zarejestruje w kontekście i będzie
 * można go wstrzyknąć przez konstruktor w innych klasach.
 *
 * Różnica między @Component a @Bean:
 *   - @Component / @Service / @Repository - Spring sam tworzy obiekt przy starcie
 *     (skan komponentów). Stosuje się dla własnych klas.
 *   - @Bean (w klasie @Configuration) - definiujemy ręcznie sposób utworzenia obiektu.
 *     Używamy gdy chcemy ręcznie podać parametry konstruktora, użyć zewnętrznej
 *     klasy (np. RestTemplate) lub klasy bez adnotacji.
 *
 * @Value("${klucz:default}") - wstrzyknięcie wartości z application.yml; "default"
 * po dwukropku to wartość fallback gdy klucza nie ma w configu.
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public SimplePojo simplePojo(@Value("${my.custom.property:Default value}") String customProperty) {
        System.out.println(customProperty);
        return new SimplePojo("Piotr", "Simple POJO created as bean", 1);
    }

    @Bean
    public List<String> defaultData() {
        return List.of("one", "two", "three", "four", "five");
    }
}
