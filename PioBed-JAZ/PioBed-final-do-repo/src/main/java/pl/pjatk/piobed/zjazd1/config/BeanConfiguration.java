package pl.pjatk.piobed.zjazd1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.piobed.zjazd1.model.SimplePojo;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public SimplePojo simplePojo(@Value("${my.custom.property:Default value from @Value}") String customProperty) {
        System.out.println(customProperty);
        return new SimplePojo("Piotr", "Bean created in @Configuration class", 1);
    }

    @Bean
    public List<String> defaultData() {
        return List.of("one", "two", "three", "four", "five");
    }
}
