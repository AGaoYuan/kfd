package cn.kfd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/17 10:04
 * @Description:
 */
@Controller
public class FTLIndexController {

    @RequestMapping("/ftlIndex")
    public String ftlIndex(Map<String,Object> map){
        map.put("name","高原"); //等同于request.setAttribute();给作用域
        map.put("age","17");
        map.put("sex","0");
        return "ftlIndex";
    }

}
