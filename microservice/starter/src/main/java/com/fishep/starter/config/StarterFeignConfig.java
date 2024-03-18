package com.fishep.starter.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fly.fei
 * @Date 2024/3/15 10:25
 * @Desc
 **/
@Configuration
public class StarterFeignConfig {

    @Bean
    Logger.Level feignLoggerLeave() {
        return Logger.Level.FULL;
    }

}
