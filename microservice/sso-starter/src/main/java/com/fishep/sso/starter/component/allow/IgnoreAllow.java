package com.fishep.sso.starter.component.allow;

import com.fishep.sso.starter.component.AllowUri;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/11 10:11
 * @Desc 无论是否登录都可以访问的路由
 **/
public class IgnoreAllow extends AbstractAllowUri {

    public IgnoreAllow(List<String> uris) {
        super(uris);
    }

    public IgnoreAllow(List<String> uris, AllowUri next) {
        super(uris, next);
    }

    @Override
    public Boolean allow(Boolean login) {
        return Boolean.TRUE;
    }

}
