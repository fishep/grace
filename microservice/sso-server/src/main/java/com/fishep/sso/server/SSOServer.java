package com.fishep.sso.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author fly.fei
 * @Date 2024/2/3 11:41
 * @Desc
 **/
@EnableDubbo
@SpringBootApplication
public class SSOServer {

    public static void main(String[] args) {
        SpringApplication.run(SSOServer.class, args);
    }

}
