package com.fishep.sso.starter.component.allow;

import com.fishep.sso.starter.component.AllowUri;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/11 10:25
 * @Desc
 **/
public abstract class AbstractAllowUri implements AllowUri {

    protected List<String> uris;

    protected AllowUri next;

    public AbstractAllowUri(List<String> uris) {
        this.uris = uris;
    }

    public AbstractAllowUri(List<String> uris, AllowUri next) {
        this.uris = uris;
        this.next = next;
    }

    @Override
    public Boolean allow(String uri, Boolean login) {
        if (uris != null) {
            for (String regex : uris) {
                if (uri.matches(regex)) {
                    return allow(login);
                }
            }
        }

        if (next != null) {
            return next.allow(uri, login);
        }

        return null;
    }

    public abstract Boolean allow(Boolean login);

}
