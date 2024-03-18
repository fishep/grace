package com.fishep.back.service.controller.demo;

import com.fishep.common.annotation.CustomResult;
import com.fishep.sso.common.interfaces.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/demo/feign")
public class FeignController {

    @Autowired
    private DemoService demoFeign;

    @CustomResult
    @GetMapping("/sayHello")
    public String sayHello() {
        String result = demoFeign.sayHello("world");
        return result;
    }

    @GetMapping("/sayThank")
    public String sayThank() {
        String result = demoFeign.sayThank("world");
        return result;
    }

    @GetMapping("/exception")
    public String exception() {
        return demoFeign.exception();
    }

    @GetMapping("/context")
    public Map<String, Object> context() {
        return demoFeign.context();
    }

}
