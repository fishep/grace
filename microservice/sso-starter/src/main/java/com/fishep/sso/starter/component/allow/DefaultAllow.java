package com.fishep.sso.starter.component.allow;

import com.fishep.sso.starter.component.AllowUri;

/**
 * @Author fly.fei
 * @Date 2024/3/11 11:13
 * @Desc
 **/
public class DefaultAllow implements AllowUri {

    @Override
    public Boolean allow(String uri, Boolean login) {
        return Boolean.TRUE;
    }

}
