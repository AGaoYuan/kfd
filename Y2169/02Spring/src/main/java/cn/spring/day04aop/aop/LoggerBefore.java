package cn.spring.day04aop.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 增强类
 */
public class LoggerBefore implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("-----Befor记录日志-----");
    }
}
