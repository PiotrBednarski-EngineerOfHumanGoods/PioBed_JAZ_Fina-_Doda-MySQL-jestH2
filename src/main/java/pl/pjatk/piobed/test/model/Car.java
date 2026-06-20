package pl.pjatk.piobed.test.model;

/**
 * Przykładowy model dla ćwiczenia 2 ze zjazdu 3 ("model np. Car").
 *
 * Zwykła klasa Javy (POJO) - bez adnotacji Springa. Jackson korzysta z konstruktora
 * bezargumentowego i setterów żeby utworzyć obiekt z JSON-a przychodzącego w body
 * (przy POST /test/model). Przy zwracaniu obiektu z metody kontrolera Jackson używa
 * getterów żeby zbudować JSON dla odpowiedzi.
 *
 * To przykład "modelu generowanego z JSON-a" - temat zaznaczony przez prowadzącego
 * jako część zakresu kolokwium.
 */
public class Car {

    private String brand;
    private String model;
    private Integer productionYear;

    public Car() {
    }

    public Car(String brand, String model, Integer productionYear) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }
}
