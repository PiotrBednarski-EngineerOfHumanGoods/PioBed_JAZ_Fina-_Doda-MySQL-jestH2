package pl.pjatk.piobed.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Konfiguracja wczytywana z pliku application.yml.
 *
 * Adnotacja @ConfigurationProperties(prefix = "app") informuje Springa, że pola
 * tej klasy mapują się na klucze w application.yml zaczynające się od "app." -
 * np. "app.environment" → field environment, "app.owner.name" → owner.name.
 *
 * Klasa musi być zarejestrowana albo przez @EnableConfigurationProperties (tak robimy
 * w PioBedApplication), albo przez adnotację @Component bezpośrednio na klasie.
 *
 * Profile w application-{dev,qa,prod}.yml nadpisują domyślną wartość pola environment,
 * co wykorzystuje FacadeService do wyboru odpowiedniej implementacji serwisu.
 */
@ConfigurationProperties(prefix = "app")
public class AppProperties {

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

    /**
     * Zagnieżdżony typ - mapowanie kluczy "app.owner.*".
     */
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
