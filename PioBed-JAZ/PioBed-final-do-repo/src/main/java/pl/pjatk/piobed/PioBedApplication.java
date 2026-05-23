package pl.pjatk.piobed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.pjatk.piobed.zjazd2.config.AppConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfigurationProperties.class)
public class PioBedApplication {

    public static void main(String[] args) {
        SpringApplication.run(PioBedApplication.class, args);
    }
}
