package com.kfd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/23 12:08
 * @Description:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.kfd.mapper")
public class AppMyBatis {

    public static void main(String[] args) {
        //运行Tomcat，启动Spring
        SpringApplication.run(AppMyBatis.class,args);
    }

}
