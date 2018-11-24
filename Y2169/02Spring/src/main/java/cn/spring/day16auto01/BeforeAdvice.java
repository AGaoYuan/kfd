package cn.spring.day16auto01;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/16 14:07
 * @Description:
 */
public class BeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("==========before===========");
    }
}
