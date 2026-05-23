package pl.pjatk.piobed.zjazd2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "app")
public class AppConfigurationProperties {

    private String environment = "DEV";
    private Owner owner = new Owner();
    private List<String> values = new ArrayList<>();

    public String getEnvironment() {
        return environment;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<String> getValues() {
        return values;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public static class Owner {
        private String name;
        private String university;

        public String getName() {
            return name;
        }

        public String getUniversity() {
            return university;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setUniversity(String university) {
            this.university = university;
        }
    }
}
