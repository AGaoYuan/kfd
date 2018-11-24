package cn.spring.day10spring01;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/12 15:12
 * @Description:
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("========before========");
    }
}
