package com.kfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 咖啡豆
 * @Date: 2019/1/1 18:54
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AppOrder {

    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }

    @Bean
    //ribbon开启本地负载均衡
    /*@LoadBalanced*/
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
