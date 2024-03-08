package com.fishep.common.type;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @Author fly.fei
 * @Date 2023/6/27 11:23
 * @Desc
 **/
public class Message {
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String EXCEPTION = "exception";
    public static final String WARN = "warn";
    public static final String ERROR = "error";
    public static final String FALLBACK = "fallback";

    public static String __(String key) {
        return SpringUtil.getBean(MessageSource.class).getMessage(key, null, key, LocaleContextHolder.getLocale());
    }

    public static String __(String key, Object arg) {
        return SpringUtil.getBean(MessageSource.class).getMessage(key, new Object[]{arg}, key, LocaleContextHolder.getLocale());
    }

    public static String __(String key, Object[] args) {
        return SpringUtil.getBean(MessageSource.class).getMessage(key, args, key, LocaleContextHolder.getLocale());
    }
}
