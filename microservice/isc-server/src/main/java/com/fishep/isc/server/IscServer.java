package com.fishep.isc.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author fly.fei
 * @Date 2024/2/3 12:09
 * @Desc
 **/
@EnableDubbo
@SpringBootApplication
public class IscServer {

    public static void main(String[] args) {
        SpringApplication.run(IscServer.class, args);
    }

}
