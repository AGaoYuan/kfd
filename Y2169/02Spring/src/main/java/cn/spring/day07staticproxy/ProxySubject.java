package cn.spring.day07staticproxy;

public class ProxySubject implements Subject {

    private RealSubject realSubject = new RealSubject();

    @Override
    public void request() {
        System.out.println("before");
        realSubject.request();
        System.out.println("after");
    }

    public RealSubject getRealSubject() {
        return realSubject;
    }

    public void setRealSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }
}
