package cn.kfd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/17 8:51
 * @Description:
 */
@RestController
public class MemberController {

    //RestController注解 表示 该类中的所有方法返回值json格式@Controller+@ResponseBody
    //@RestController 不是SpringBoot提供的
    //SpringgBoot 启动原理：SpringMVC注解方式启动 内置服务器
    //1.EnableAutoConfiguration 注解作用：扫包范围 默认在当前类里面
    //2.启动加上扫包范围ComponentScan指定扫包范围

    @RequestMapping("/memberIndex")
    public String memberIndex(){
        return "SpringBoot2.0测试！！！";
    }


}
