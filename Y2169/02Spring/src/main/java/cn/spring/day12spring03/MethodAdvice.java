package cn.spring.day12spring03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/12 15:50
 * @Description:  环绕增强
 */
public class MethodAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("===before");
        methodInvocation.proceed();
        System.out.println("===after");

        return null;
    }
}
