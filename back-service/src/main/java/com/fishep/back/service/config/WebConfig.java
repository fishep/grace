package com.fishep.back.service.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ServletComponentScan("com.fishep.back.service.filter")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api", clazz -> clazz.isAnnotationPresent(RestController.class));
        WebMvcConfigurer.super.configurePathMatch(configurer);
    }

}
