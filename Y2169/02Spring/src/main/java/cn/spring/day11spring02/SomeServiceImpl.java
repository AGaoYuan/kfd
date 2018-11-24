package cn.spring.day11spring02;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/10 17:01
 * @Description: 前置增强
 */
public class SomeServiceImpl implements ISomeService {

    @Override
    public int doSome() {
        System.out.println("do something  ===After");
        return 132;
    }
}
