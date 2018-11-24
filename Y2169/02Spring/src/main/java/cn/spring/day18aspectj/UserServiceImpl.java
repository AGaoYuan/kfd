package cn.spring.day18aspectj;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/18 16:17
 * @Description:
 */
public class UserServiceImpl implements IUserService {

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
       // int a = 5/0;
        System.out.println("delete OK!");
    }

    @Override
    public String select(String sql) {
        System.out.println("select OK!");
        return  "select";
    }
}
