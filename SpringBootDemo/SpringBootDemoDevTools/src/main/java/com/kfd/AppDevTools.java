package com.kfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/30 13:57
 * @Description:
 */
@SpringBootApplication
/*@ComponentScan(basePackages = "com.kfd.controller")
@EnableAutoConfiguration*/
public class AppDevTools {

    public static void main(String[] args) {
        SpringApplication.run(AppDevTools.class,args);

    }

}
