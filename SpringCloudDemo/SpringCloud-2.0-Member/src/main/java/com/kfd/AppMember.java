package com.kfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: 咖啡豆
 * @Date: 2019/1/1 18:34
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class AppMember {

    //将Member会员服务注册到eureka注册中心上
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class,args);
    }

}
