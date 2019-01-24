package com.kfd.controller;

import com.kfd.model.RealEstate;
import com.kfd.service.RealEstateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/14 10:44
 * @Description:
 */
@Controller
public class RealController {

    @Autowired
    private RealEstateServiceImpl service;

    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        List<RealEstate> list = service.findAll(1,2);
        map.put("Reallist",list);
        return "index";
    }

    @RequestMapping("/findByName")
    public String findByName(String type,String name,Map<String,Object> map){
        map.put("type",type);
        map.put("name",name);
        System.out.println(type+"++++++"+name);
        return "findByName";
    }


}
