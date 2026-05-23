package pl.pjatk.piobed.zjazd1.profile;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileBeanConfiguration {

    @Bean
    @ConditionalOnProperty(name = "custom.enabled", havingValue = "true")
    public ProfileBean profileBean() {
        return new ProfileBean();
    }
}
