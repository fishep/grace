package com.fishep.sso.starter.component.allow;

import com.fishep.sso.starter.component.AllowUri;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/11 10:11
 * @Desc 不能在登录的状态下访问的路由
 **/
public class UnauthAllow extends AbstractAllowUri {

    public UnauthAllow(List<String> uris) {
        super(uris);
    }

    public UnauthAllow(List<String> uris, AllowUri next) {
        super(uris, next);
    }

    @Override
    public Boolean allow(Boolean login) {
        return !login;
    }

}
