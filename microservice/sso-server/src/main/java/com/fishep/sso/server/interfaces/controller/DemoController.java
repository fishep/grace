package com.fishep.sso.server.interfaces.controller;

import com.fishep.server.annotation.CustomResult;
import org.springframework.web.bind.annotation.*;

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

}
