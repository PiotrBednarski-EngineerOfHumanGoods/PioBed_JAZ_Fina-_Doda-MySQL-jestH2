package pl.pjatk.piobed.profile;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Warunkowa rejestracja beana w zależności od zawartości application.yml.
 *
 * Adnotacja @ConditionalOnProperty(name = "custom.enabled", havingValue = "true")
 * sprawia, że bean profileBean() zostanie zarejestrowany TYLKO gdy w application.yml
 * (lub application-{profil}.yml) klucz "custom.enabled" ma wartość "true".
 *
 * W tym projekcie profil "dev" (application-dev.yml) ustawia custom.enabled = true,
 * więc po uruchomieniu z parametrem --spring.profiles.active=dev bean zostanie utworzony.
 */
@Configuration
public class ProfileBeanConfiguration {

    @Bean
    @ConditionalOnProperty(name = "custom.enabled", havingValue = "true")
    public ProfileBean profileBean() {
        return new ProfileBean();
    }
}
