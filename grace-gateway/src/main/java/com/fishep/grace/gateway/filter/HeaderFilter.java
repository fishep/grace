package com.fishep.grace.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author fly.fei
 * @Date 2024/3/7 16:32
 * @Desc 禁用一些请求头，这些特定的请求头用于在服务之间传递上下文内容使用
 **/
@Component
public class HeaderFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("HeaderFilter");

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
