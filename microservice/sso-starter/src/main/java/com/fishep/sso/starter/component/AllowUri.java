package com.fishep.sso.starter.component;

/**
 * @Author fly.fei
 * @Date 2024/3/9 10:06
 * @Desc 请求的允许策略，用于规定，那些uri不能在登录的状态下访问，那些uri无论是否登录都可以访问，那些uri必须在登录的状态下才能访问
 **/
public interface AllowUri {

    /**
     * @param uri    请求的uri
     * @param login  是否已登录
     * @return 是否允许请求通过
     */
    Boolean allow(String uri, Boolean login);

}
