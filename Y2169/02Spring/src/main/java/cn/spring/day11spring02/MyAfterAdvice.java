package cn.spring.day11spring02;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/22 15:07
 * @Description:
 */
public class MyAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After---------------"+returnValue);

    }
}
