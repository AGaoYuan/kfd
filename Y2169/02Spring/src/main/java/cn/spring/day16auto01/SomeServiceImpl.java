package cn.spring.day16auto01;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/10 17:01
 * @Description:
 */
public class SomeServiceImpl implements ISomeService {


    @Override
    public void save() {
        System.out.println("Save OK!");
    }

    @Override
    public void update() {
        System.out.println("update OK!");
    }

    @Override
    public void delete() {
        System.out.println("delete OK!");
    }

    @Override
    public void select() {
        System.out.println("select OK!");
    }
}
