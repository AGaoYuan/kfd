package cn.happy.test;

import java.io.Serializable;

public class Student implements Serializable{

    private int stuid;
    private String name;
    private int stuAge;

    public Student() {}

    public Student(int stuid, String name, int stuAge) {
        this.stuid = stuid;
        this.name = name;
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", name='" + name + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
}
