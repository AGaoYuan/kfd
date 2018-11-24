package cn.spring.day08jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/10 17:02
 * @Description:
 */
public class Test {

    /**
     * JDK完成动态代理
     * @param args
     */
    public static void main(String[] args) {
        final ISomeService service = new SomeServiceImpl();

        ISomeService proxy = (ISomeService) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before");
                        method.invoke(service, args);
                        return null;
                    }
                });
        proxy.doSome();

    }


}
