package cn.happy.day01;

import cn.spring.day01.HappyService;
import cn.spring.day03printer.printer.Printer;
import cn.spring.day04aop.service.IHelloService;
import cn.spring.day05xmldi.MyCollection;
import cn.spring.day06anntationdi.Student;
import cn.spring.day07staticproxy.ProxySubject;
import cn.spring.day07staticproxy.RealSubject;
import cn.spring.day19aspectjXML.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 你好，Spring
 */
public class SpringTest {

    @Test
    public void Test014(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day018aspectjXML.xml");
        IUserService s = (IUserService) context.getBean("service");
        s.select();

    }



    @Test
    public void Test013(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day017aspectj.xml");
        IUserService s = (IUserService) context.getBean("service");
        //s.save();
        //s.select("SQL");
        //s.delete();
        s.update();

    }




    @Test
    public void Test012(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day016auto01.xml");
        /*ISomeService s = (ISomeService) context.getBean("service");
        s.select();*/

    }





    @Test
    public void Test011(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day015advisor02.xml");
        //ISomeService s = (ISomeService) context.getBean("proxyService");
        /*s.doAny();
        s.doSome();*/


    }



    @Test
    public void Test10(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day015advisor01.xml");
        //ISomeService s = (ISomeService) context.getBean("proxyService");
        /*s.doSome();
        s.doAny();*/


    }



    @Test
    public void Test09(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day014aop04.xml");

        //ISomeService s = (ISomeService) context.getBean("proxyService");

        try {
            /*s.doSome();*/
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }



    @Test
    public void Test08(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day013aop03.xml");
        //ISomeService s = (ISomeService) context.getBean("proxyService");
        /*s.doSome();*/

    }



    @Test
    public void Test07(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day011aop01.xml");
        //ISomeService s = (ISomeService) context.getBean("proxyService");
        /*s.doSome();*/

    }


    /*静态代理*/
    @Test
    public void Test06(){
        RealSubject subject = new RealSubject();
        subject.request();

        System.out.println("----------------");
        ProxySubject sub = new ProxySubject();
        sub.setRealSubject(subject);

        sub.request();

    }




    @Test
    public void Test05(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day05anntationindi.xml");
        Student s = (Student) context.getBean("Student");
        System.out.println(s.getName()+"++++"+s.getAge()+"------>"+s.getCar().getColor());


    }



    @Test
    public void Test04(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day04xmldi.xml");
        Student stu = (Student) context.getBean("stu");
        /*String [] arr = {};
        List<String[]> list = new ArrayList<String[]>();
        list.add(arr);*/
        /*MyCollection c = (MyCollection) context.getBean("collection");
        for (String item:c.getList()) {
            System.out.println(item);
        }*/
        System.out.println(stu.toString());

    }


    @Test
    public void Test03(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day03aop.xml");
        IHelloService bean = (IHelloService) context.getBean("service");
        bean.doSome();

    }


  /*  @Test
    public void Test02(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day02di.xml");
        Student bean = (Student) context.getBean("student");

        System.out.println(bean.getCar().getColor());

    }*/


    @Test
    public void Test01(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       /* HappyService bean = (HappyService) context.getBean("service");
        System.out.println(bean);*/
        Printer printer = (Printer) context.getBean("printer");
        printer.print();

    }



}
