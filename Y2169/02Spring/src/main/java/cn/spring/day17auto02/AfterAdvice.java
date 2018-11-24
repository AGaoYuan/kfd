package cn.spring.day17auto02;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/22 16:32
 * @Description:
 */
public class AfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after--------------------");
    }
}
