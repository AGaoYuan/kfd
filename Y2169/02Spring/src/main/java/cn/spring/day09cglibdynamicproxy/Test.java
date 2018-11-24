package cn.spring.day09cglibdynamicproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/12 14:53
 * @Description:   CGLIB 动态代理
 */
public class Test {

    public static void main(String[] args) {
        final SomeServiceImpl service = new SomeServiceImpl();

        //CGLIB 动态代理
        Enhancer enhancer = new Enhancer();

        //调度父类模板
        enhancer.setSuperclass(service.getClass());
        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o 代理对象
             * @param method 目标类型的方法
             * @param objects 目标方法参数
             * @param methodProxy 代理类的方法  新的参数
             * @return
             * @throws Throwable
             */

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("===========before");
                Object result = methodProxy.invoke(service, objects);
                return result;
            }
        });

        //创建出代理对象
        SomeServiceImpl proxy = (SomeServiceImpl) enhancer.create();
        //调度增强后的doSome方法
        proxy.doSome();

    }

  /*  public static void main(String[] args) {
        final SomeServiceImpl service = new SomeServiceImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(service.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("增强--------");
                Object invoke = methodProxy.invoke(service, objects);
                return invoke;
            }
        });
        SomeServiceImpl proxy = (SomeServiceImpl) enhancer.create();
        proxy.doSome();
    }
*/
}
