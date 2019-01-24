package com.kfd.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2019/1/1 18:32
 * @Description:
 */
@RestController
public class MemberApiController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getMember")
    public String getMember(){
        return "this is member 我是会员服务，springcloud2.0，端口号："+serverPort;
    }

}
