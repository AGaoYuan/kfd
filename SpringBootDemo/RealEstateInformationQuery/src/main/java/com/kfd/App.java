package com.kfd;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/14 10:47
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.kfd.dao")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
