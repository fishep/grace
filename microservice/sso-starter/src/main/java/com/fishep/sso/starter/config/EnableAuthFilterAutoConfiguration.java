package com.fishep.sso.starter.config;

import com.fishep.sso.starter.annotation.pojo.EnableAuthFilter;
import com.fishep.sso.starter.component.AllowUri;
import com.fishep.sso.common.interfaces.AuthService;
import com.fishep.sso.starter.component.allow.*;
import com.fishep.sso.starter.feign.AuthFeign;
import com.fishep.sso.starter.web.filter.AllowUriFilter;
import com.fishep.sso.starter.web.filter.AuthFilter;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fly.fei
 * @Date 2024/3/12 10:19
 * @Desc
 **/
@Configuration
@ConditionalOnBean(EnableAuthFilter.class)
public class EnableAuthFilterAutoConfiguration {

    @DubboReference
    private AuthService authService;

//    @Autowired
//    private AuthFeign authService;

    @Bean
    public AllowUri allowUri(AllowUriPath allowUriPath) {
        AllowUri defaultPolicy;
        if (allowUriPath.getFallback() != null && allowUriPath.getFallback().equals("allow")) {
            defaultPolicy = new DefaultAllow();
        } else {
            defaultPolicy = new DefaultDeny();
        }
        AuthedAllow authedAllow = new AuthedAllow(allowUriPath.getAuthed(), defaultPolicy);
        IgnoreAllow ignoreAllow = new IgnoreAllow(allowUriPath.getIgnore(), authedAllow);
        UnauthAllow unauthAllow = new UnauthAllow(allowUriPath.getUnauth(), ignoreAllow);

        return unauthAllow;
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> authFilterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AuthFilter(authService));
        registration.addUrlPatterns("/*");
        registration.setName("authFilter");
        registration.setOrder(0);

        return registration;
    }

    @Bean
    public FilterRegistrationBean<AllowUriFilter> allowUriFilterRegistrationBean(AllowUri allowUri) {
        FilterRegistrationBean<AllowUriFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AllowUriFilter(allowUri));
        registration.addUrlPatterns("/*");
        registration.setName("allowUriFilter");
        registration.setOrder(1);

        return registration;
    }

}
