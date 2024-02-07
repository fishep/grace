package com.fishep.isc.server.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2024/2/3 11:59
 * @Desc
 **/
@RestController
@RequestMapping("/test")
public class TestRestController {

    @GetMapping("/hello")
    public String api() {
        return "hello isc api";
    }
    
}
