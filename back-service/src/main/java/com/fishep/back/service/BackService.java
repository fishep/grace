package com.fishep.back.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2024/2/3 14:58
 * @Desc
 **/
@RestController
@SpringBootApplication
public class BackService {

    @GetMapping("/back/api")
    public String api() {
        return "hello Back Service api";
    }

    public static void main(String[] args) {
        SpringApplication.run(BackService.class, args);
    }

}
