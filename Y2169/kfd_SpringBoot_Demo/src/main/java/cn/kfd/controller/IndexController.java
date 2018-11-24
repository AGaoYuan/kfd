package cn.kfd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/17 9:10
 * @Description:
 */
@RestController
public class IndexController {

    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    /*@RequestMapping("/index")*/
    @PostMapping("/index")
    public String index(@RequestParam("name") String name,@RequestParam("age") String age){

        //logger.debug("SpringBoot 整合log4j");

        return "SpringBoot2.0 Index!!!"+name+"+++"+age;
    }
}
