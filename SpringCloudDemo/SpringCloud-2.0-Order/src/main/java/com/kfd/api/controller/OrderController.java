package com.kfd.api.controller;

import com.kfd.feign.MemberApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2019/1/1 18:47
 * @Description:
 */
@RestController
public class OrderController {

    //SpringBootWeb组件提供
    /*@Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MemberApiFeign memberApiFeign;

    /*@RequestMapping("/getOrder")
    public String getOrder(){
        String url = "http://app-kfd-member/getMember";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("订单服务调用会员服务结果："+result);
        return result;
    }*/

    /**
     * 调用会员服务，从注册中心上寻找相关信息，借助DiscoveryClient这个接口
     * @return
     */
    @RequestMapping("/discoveryClientMember")
    public List<ServiceInstance> discoveryClientMember(){
        List<ServiceInstance> instances = discoveryClient.getInstances("app-kfd-member");
        for (ServiceInstance item:instances){
            System.out.println(item.getUri());
        }
        return instances;
    }

    @RequestMapping("/feignMember")
    public String feignMember(){
        return memberApiFeign.getMember();
    }

}
