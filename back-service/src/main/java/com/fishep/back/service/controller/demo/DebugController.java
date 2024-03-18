package com.fishep.back.service.controller.demo;

import com.fishep.common.annotation.CustomResult;
import com.fishep.common.context.GlobalContextHolder;
import com.fishep.common.exception.ServiceException;
import com.fishep.sso.common.interfaces.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/3/4 15:44
 * @Desc
 **/
@RestController
@RequestMapping("/demo/debug")
public class DebugController {

    @Autowired
    private DemoService demoFeign;

    @DubboReference
    private DemoService demoDubbo;

    @GetMapping("/exception")
    public String exception() {
        throw new ServiceException("DebugController exception");
    }

    @GetMapping("/context")
    public Map<String, Object> context() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", GlobalContextHolder.getUser());
        map.put("platform", GlobalContextHolder.getPlatform());

        return map;
    }

    @CustomResult
    @GetMapping("/sayHelloByFeign")
    public String sayHelloByFeign() {
        String result = demoFeign.sayHello("world");
        return result;
    }

    @CustomResult
    @GetMapping("/sayHelloByDubbo")
    public String sayHelloByDubbo() {
        String result = demoDubbo.sayHello("world");
        return result;
    }

}
