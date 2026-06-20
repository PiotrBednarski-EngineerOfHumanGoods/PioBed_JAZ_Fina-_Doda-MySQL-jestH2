package pl.pjatk.piobed.pojo;

/**
 * Prosty POJO (Plain Old Java Object) - zwykła klasa Javy bez adnotacji Springa.
 *
 * W tym projekcie używany jako przykład beana tworzonego ręcznie w klasie
 * @Configuration (BeanConfiguration.simplePojo()) - obiekt nie ma @Component,
 * więc Spring nie utworzy go sam; trzeba zwrócić go z metody oznaczonej @Bean.
 */
public class SimplePojo {

    private String name;
    private String description;
    private Integer number;

    public SimplePojo(String name, String description, Integer number) {
        this.name = name;
        this.description = description;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getNumber() {
        return number;
    }
}
