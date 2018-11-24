package cn.spring.day06anntationdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("Student")
public class Student {
    @Value("小黑")
    private String name;
    @Value("12")
    private Integer age;

    /*JDK默认提供的域属性注解*/
   /* @Resource(name = "car")*/
    @Autowired()
    private Car car;


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
