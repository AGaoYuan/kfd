package cn.spring.day07staticproxy;

public class RealSubject implements Subject {


    @Override
    public void request() {
        System.out.println("realSubject");
    }
}
