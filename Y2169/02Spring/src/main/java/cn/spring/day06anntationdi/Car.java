package cn.spring.day06anntationdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {

    @Value("黑色")
    private String Color;


    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
