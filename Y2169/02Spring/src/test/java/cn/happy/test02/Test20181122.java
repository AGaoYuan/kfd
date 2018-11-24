package cn.happy.test02;

import cn.spring.day14advisor01.ISomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/22 15:11
 * @Description:
 */
public class Test20181122 {

    /**
     * 顾问
     */
    @Test
    public void t4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-day015advisor01.xml");
        ISomeService service = (ISomeService) ctx.getBean("proxyService");
        service.doSome();
        service.doAny();

    }

    /**
     * auto自动代理
     */
    @Test
    public void t3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-day016auto02.xml");
        ISomeService advisor = (ISomeService) ctx.getBean("service");
        //advisor.select();

    }


    @Test
    public void t2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-day014aop04.xml");
        ISomeService proxyService = (ISomeService) ctx.getBean("proxyService");
        try {
            //proxyService.doSome();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }


    @Test
    public void t1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-day012aop02.xml");
        ISomeService proxyService = (ISomeService) ctx.getBean("proxyService");
        /*int i = proxyService.doSome();
        System.out.println(i);*/

    }



}
