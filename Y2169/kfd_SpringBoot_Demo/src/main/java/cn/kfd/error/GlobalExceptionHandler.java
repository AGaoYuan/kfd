package cn.kfd.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常案例
 * 1.捕获json格式
 * 2.获取返回页面
 *
 * @Author: 咖啡豆
 * @Date: 2018/11/20 11:23
 * @Description:
 */
@ControllerAdvice(basePackages = "cn.kfd.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> errorResult(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("errorCode","500");
        map.put("errMsg","全局捕获异常系统错误！");
        return map;
    }


}
