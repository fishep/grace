package com.fishep.sso.starter.component.allow;

import com.fishep.sso.starter.component.AllowUri;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/11 10:12
 * @Desc 必须在登录的状态下才能访问的路由
 **/
public class AuthedAllow extends AbstractAllowUri {

    public AuthedAllow(List<String> uris) {
        super(uris);
    }

    public AuthedAllow(List<String> uris, AllowUri next) {
        super(uris, next);
    }

    @Override
    public Boolean allow(Boolean login) {
        return login;
    }

}
