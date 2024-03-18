package com.fishep.sso.starter.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author fly.fei
 * @Date 2024/3/12 10:10
 * @Desc
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(com.fishep.sso.starter.annotation.pojo.EnableAuthFilter.class)
public @interface EnableAuthFilter {
}
