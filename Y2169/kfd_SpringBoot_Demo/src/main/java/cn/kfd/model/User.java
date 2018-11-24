package cn.kfd.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/20 12:02
 * @Description:
 */
@Slf4j
@Data
public class User {

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        User u = new User();
        u.setName("高原");
        u.setAge(20);
        log.debug("数据"+u);
        //System.out.println(u);
    }


}
