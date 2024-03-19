package com.fishep.back.service.controller.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2024/3/19 14:36
 * @Desc
 **/
@Slf4j
@RestController
@RequestMapping("/demo/logger")
public class LoggerController {

    @GetMapping("/trace")
    public String trace() {
        log.trace("log trace");
        return "log trace";
    }

    @GetMapping("/debug")
    public String debug() {
        log.debug("log debug");
        return "log debug";
    }

    @GetMapping("/info")
    public String info() {
        log.info("log info");
        return "log info";
    }

    @GetMapping("/warn")
    public String warn() {
        log.warn("log warn");
        return "log warn";
    }

    @GetMapping("/error")
    public String error() {
        log.error("log error");
        return "log error";
    }

}
