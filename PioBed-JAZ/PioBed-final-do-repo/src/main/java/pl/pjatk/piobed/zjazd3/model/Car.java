package pl.pjatk.piobed.zjazd3.model;

public class Car {

    private String brand;
    private String model;
    private int productionYear;

    public Car() {
    }

    public Car(String brand, String model, int productionYear) {
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

    public int getProductionYear() {
        return productionYear;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}
