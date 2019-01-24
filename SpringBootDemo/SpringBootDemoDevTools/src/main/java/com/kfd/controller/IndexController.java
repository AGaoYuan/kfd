package com.kfd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/30 13:57
 * @Description:
 */
@RestController
public class IndexController {

    @RequestMapping("/indexDev")
    public String indexDev(){
        String result="SpringBoot 2.0 DevTools2.0";
        return result;
    }

    @RequestMapping("/index")
    public String index(){
        return "123456";
    }

}
