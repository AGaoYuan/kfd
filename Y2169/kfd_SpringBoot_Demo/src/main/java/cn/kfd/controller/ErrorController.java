package cn.kfd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/20 11:29
 * @Description:
 */
@RestController
public class ErrorController {

    @RequestMapping("getUser")
    public String getUser(int i){
        int j = 1/i;
        return "success"+j;
    }

}
