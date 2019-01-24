package com.kfd;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/11 17:13
 * @Description:
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@ComponentScan("com.kfd.controller")
public class AdminUIServer {

    public static void main(String[] args) {
        SpringApplication.run(AdminUIServer.class,args);
    }

}
