package com.fishep.starter.feign.interceptor;

import com.fishep.common.context.GlobalContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author fly.fei
 * @Date 2024/3/7 17:15
 * @Desc 客户端传递全局上下文的内容，服务端接收处理 {@link GlobalContextFilter}
 **/
@Component
public class FeignGlobalContextInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        System.out.println("FeignGlobalContextInterceptor Thread:" + Thread.currentThread().getName());

        GlobalContextHolder.load(template::header);
    }

}
