package cn.spring.day05xmldi;

public class Car {

    private String Color;
    private String brand;


    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Color='" + Color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
