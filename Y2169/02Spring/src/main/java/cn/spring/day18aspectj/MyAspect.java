package cn.spring.day18aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/18 16:18
 * @Description:
 */
@Aspect
public class MyAspect {

    @Pointcut(value = "execution(* *..day18aspectj.*.select(..))")
    public void select(){

    }

    @Pointcut(value = "execution(* *..day18aspectj.*.update(..))")
    public void update(){

    }


    //前置增强
    @Before("execution(* *..day18aspectj.*.select(..))")
    public void myBefore(JoinPoint joinpoint){
        System.out.println("=======before"+joinpoint);
    }



    //后置增强
    @AfterReturning("select()||update()")
    public void myAfterReturning(){
        System.out.println("=============after");
    }





    //环绕增强
    @Around("execution(* *..day18aspectj.*.save(..))")
    public void myAround(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("=============before");
        pjp.proceed();
        System.out.println("=============after");
    }


    @AfterThrowing(value = "execution(* *..day18aspectj.*.delete(..))",throwing = "error" )
    public void myAroundThrowing(Exception error) throws Throwable{
        System.out.println("=============throwing ........============"+error.getMessage());
    }

    @After(value = "execution(* *..day18aspectj.*.delete(..))")
    public void myAfter() {
        System.out.println("=============最终通知============");
    }


}
