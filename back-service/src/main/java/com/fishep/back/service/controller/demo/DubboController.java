package com.fishep.back.service.controller.demo;

import com.fishep.common.annotation.CustomResult;
import com.fishep.sso.common.interfaces.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/3/4 15:44
 * @Desc
 **/
@RestController
@RequestMapping("/demo/dubbo")
public class DubboController {

    @DubboReference
    private DemoService demoService;

    @CustomResult
    @GetMapping("/sayHello")
    public String sayHello() {
        String result = demoService.sayHello("world");
        return result;
    }

    @GetMapping("/sayThank")
    public String sayThank() {
        String result = demoService.sayThank("world");
        return result;
    }

    @GetMapping("/exception")
    public String exception() {
        return demoService.exception();
    }

    @GetMapping("/context")
    public Map<String, Object> context() {
        return demoService.context();
    }

}
