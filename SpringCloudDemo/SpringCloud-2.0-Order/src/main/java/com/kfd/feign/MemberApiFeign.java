package com.kfd.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 咖啡豆
 * @Date: 2019/1/15 16:11
 * @Description:
 */
@FeignClient(name = "app-kfd-member")
public interface MemberApiFeign {

    @RequestMapping("/getMember")
    public String getMember();

}
