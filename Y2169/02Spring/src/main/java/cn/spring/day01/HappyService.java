package cn.spring.day01;

/**
 *第一个Spring Demo
 */
public class HappyService {

    private String info;
    private Integer age;

    public HappyService() {
        System.out.println("-------------HappyService初始化-------------");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "HappyService{" +
                "info='" + info + '\'' +
                ", age=" + age +
                '}';
    }
}
