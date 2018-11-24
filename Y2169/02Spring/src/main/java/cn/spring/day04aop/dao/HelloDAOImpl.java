package cn.spring.day04aop.dao;

public class HelloDAOImpl implements  IHelloDAO {


    @Override
    public void doSome() {
        System.out.println("数据成功写入到DB");
    }
}
