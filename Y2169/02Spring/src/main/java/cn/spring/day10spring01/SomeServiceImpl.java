package cn.spring.day10spring01;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/10 17:01
 * @Description: 前置增强
 */
public class SomeServiceImpl implements ISomeService {


    @Override
    public void doSome() {
        System.out.println("do something===");
    }
}
