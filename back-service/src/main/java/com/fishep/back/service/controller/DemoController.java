package com.fishep.back.service.controller;

import com.fishep.sso.common.interfaces.DemoService;
import com.fishep.sso.starter.feign.DemoFeign;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2024/3/4 15:44
 * @Desc
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @DubboReference
    private DemoService demoService;

    @Autowired
    private DemoService demoFeign;

    @GetMapping("/sayHello/byFeign")
    public String sayHelloByFeign() {
        String result = demoFeign.sayHello("world");

        return result;
    }

    @GetMapping("/sayHello/byDubbo")
    public String sayHelloByDubbo() {
        String result = demoService.sayHello("world");

        return result;
    }

}
