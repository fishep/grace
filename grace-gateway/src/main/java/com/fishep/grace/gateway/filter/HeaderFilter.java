package com.fishep.grace.gateway.filter;

import com.fishep.common.context.GlobalContextKey;
import com.fishep.common.exception.ServiceError;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.fishep.common.type.Message.PROHIBIT_HEADER;
import static com.fishep.common.type.Message.__;

/**
 * @Author fly.fei
 * @Date 2024/3/7 16:32
 * @Desc 禁用一些请求头，这些特定的请求头用于在服务之间传递上下文内容使用
 **/
@Component
public class HeaderFilter implements GlobalFilter, Ordered {

    private static List<String> prohibitHeaders;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        if (prohibitHeaders == null) {
            prohibitHeaders = GlobalContextKey.getKeys();
        }

        HttpHeaders headers = exchange.getRequest().getHeaders();

        // 服务内部全局请求头，禁止客户端使用
        for (String ph : prohibitHeaders) {
            if (headers.getFirst(ph) != null) {
                throw new ServiceError(__(PROHIBIT_HEADER, ph));
            }
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
