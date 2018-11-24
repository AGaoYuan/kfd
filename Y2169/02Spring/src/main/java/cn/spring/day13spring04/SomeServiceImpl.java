package cn.spring.day13spring04;


/**
 * @Author: 咖啡豆
 * @Date: 2018/10/10 17:01
 * @Description:
 */
public class SomeServiceImpl implements ISomeService {


    @Override
    public void doSome() {
        int result = 5/0;
        System.out.println("do something===");
    }
}
