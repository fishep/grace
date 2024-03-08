package com.fishep.sso.starter.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fly.fei
 * @Date 2024/3/1 10:09
 * @Desc
 **/
@Configuration
@ComponentScan("com.fishep.sso.starter")
@EnableFeignClients({"com.fishep.sso.starter"})
public class SSOStarterAutoConfiguration {
}
