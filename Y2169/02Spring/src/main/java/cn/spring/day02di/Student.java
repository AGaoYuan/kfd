package cn.spring.day02di;

/**
 * 学生对象
 */
public class Student {

    private String StuName;
    private Integer StuAge;

    //域属性
    private Car car;


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public Integer getStuAge() {
        return StuAge;
    }

    public void setStuAge(Integer stuAge) {
        StuAge = stuAge;
    }
}
