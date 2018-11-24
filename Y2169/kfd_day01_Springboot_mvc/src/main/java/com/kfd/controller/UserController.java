package com.kfd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/7 13:31
 * @Description:
 */
@Controller
public class UserController {

    @RequestMapping("/pageIndex")
    public String pageIndex(){
        return "pageIndex";
    }

}
