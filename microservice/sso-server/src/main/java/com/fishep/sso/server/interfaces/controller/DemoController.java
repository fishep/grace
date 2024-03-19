package com.fishep.sso.server.interfaces.controller;

import com.fishep.common.annotation.CustomResult;
import com.fishep.common.context.GlobalContextHolder;
import com.fishep.common.exception.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/2/3 11:59
 * @Desc
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @CustomResult
    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return "hello " + name;
    }

    @GetMapping("/sayThank")
    public String sayThank(@RequestParam String name) {
        return "thank " + name;
    }

    @GetMapping("/exception")
    public String exception() {
        throw new ServiceException("sso DemoController exception");
    }

    @GetMapping("/context")
    public Map<String, Object> context() {
        HashMap<String, Object> map = new HashMap<>();
        GlobalContextHolder.load(map::put);

        return map;
    }

}
