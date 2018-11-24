package cn.spring.day04aop.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LoggerAfter implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After后置增强");
    }

}
