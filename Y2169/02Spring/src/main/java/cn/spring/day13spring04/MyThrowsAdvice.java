package cn.spring.day13spring04;

import org.springframework.aop.ThrowsAdvice;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/12 15:58
 * @Description:
 */
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex){
        System.out.println("网络异常出现了！！");
    }

}
