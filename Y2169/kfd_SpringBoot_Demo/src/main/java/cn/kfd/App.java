package cn.kfd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/17 9:13
 * @Description:
 *
 *
 */

/*@EnableAutoConfiguration
@ComponentScan("cn.kfd.controller")*/
@SpringBootApplication
/*@EnableAsync*/
@MapperScan(basePackages = "cn.kfd.mapper")
public class App {

    public static void main(String[] args) {
        //整个程序的入口，启动SpringBoot项目
        SpringApplication.run(App.class,args);
    }


}
