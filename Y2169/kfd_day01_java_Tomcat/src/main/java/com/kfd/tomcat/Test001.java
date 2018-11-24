package com.kfd.tomcat;

import com.kfd.web.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * 使用java语言创建tomcat服务器<br>
 * Tomcat底层执行程序  最终Servlet<br>
 * SpringMVC底层使用Servlet 包装<br>
 *
 * @Author: 咖啡豆
 * @Date: 2018/11/7 11:20
 * @Description:
 */
public class Test001 {

    private static int POPT = 8080;

    private static String PATH = "/kfd";

    private static String SERVLET_NAME = "indexServlet";

    public static void main(String[] args) throws Exception {

        //创建tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        //指定端口号
        tomcatServer.setPort(POPT);
        //是否自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        //创建上下文
        StandardContext standardContext = new StandardContext();
        standardContext.setPath(PATH);
        //监听上下文
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        //tomcat容器添加standardContext
        tomcatServer.getHost().addChild(standardContext);

        //创建Servlet
        tomcatServer.addServlet(PATH,SERVLET_NAME,new IndexServlet());
        //servleturl映射
        standardContext.addServletMappingDecoded("/index",SERVLET_NAME);

        tomcatServer.start();
        System.out.println("Tomcat已启动！！！");
        //异步进行接收请求
        tomcatServer.getServer().await();

    }

}
