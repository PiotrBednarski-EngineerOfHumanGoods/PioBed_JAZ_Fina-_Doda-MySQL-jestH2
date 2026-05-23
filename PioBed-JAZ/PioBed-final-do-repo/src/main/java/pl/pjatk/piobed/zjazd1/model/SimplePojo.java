package pl.pjatk.piobed.zjazd1.model;

public class SimplePojo {

    private String name;
    private String description;
    private int number;

    public SimplePojo(String name, String description, int number) {
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

    public int getNumber() {
        return number;
    }
}
