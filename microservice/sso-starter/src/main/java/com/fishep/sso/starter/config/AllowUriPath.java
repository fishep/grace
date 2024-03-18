package com.fishep.sso.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/11 10:00
 * @Desc
 **/
@Data
@Component
@ConfigurationProperties(prefix = "service.routes")
public class AllowUriPath {

    //    不能在登录的状态下访问的路由, uri的正则表达式
    private List<String> unauth;

    //    无论是否登录都可以访问的路由, uri的正则表达式
    private List<String> ignore;

    //    必须在登录的状态下才能访问的路由, uri的正则表达式
    private List<String> authed;

    //    没有匹配到所有的规则的兜底策略，deny: 拒绝，allow: 允许
    private String fallback;

}
