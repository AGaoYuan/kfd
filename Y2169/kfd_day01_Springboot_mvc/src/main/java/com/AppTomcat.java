package com;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/7 13:08
 * @Description:
 */
public class AppTomcat {

    private static int POPT = 8080;

   /* private static String PATH = "/kfd";

    private static String SERVLET_NAME = "indexServlet";*/

    public static void main(String[] args) throws Exception {
        start();
    }

    public static void start() throws Exception{
        //创建tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        //指定端口号
        tomcatServer.setPort(POPT);
        //读取项目路径
        StandardContext ctx = (StandardContext)
                tomcatServer.addWebapp("/",new File("src/main").getAbsolutePath());
        //禁止重新载入
        ctx.setReloadable(false);
        //class文件读取地址
        File additionWebInfoClasses = new File("target/classes");
        //创建WebRoot
        WebResourceRoot resources = new StandardRoot(ctx);
        //tomcat内部读取Class执行
        resources.addPreResources(new DirResourceSet(resources,"/WEB-INF/classes",additionWebInfoClasses.getAbsolutePath(),"/"));

        //启动Tomcat
        tomcatServer.start();
        //异步进行接收请求
        tomcatServer.getServer().await();
    }


}
