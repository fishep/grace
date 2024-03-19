package com.fishep.server.web.filter;

import com.fishep.common.context.GlobalContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author fly.fei
 * @Date 2024/3/7 17:15
 * @Desc 服务端接收全局上下文，客户端传递 {@link FeignInterceptor}
 **/
@Slf4j
@Order(0)
@Component
public class GlobalContextFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.trace("doFilter, RequestId is " + request.getRequestId());

        GlobalContextHolder.unload(request::getHeader);

        try {
            super.doFilter(request, response, chain);
        } catch (Exception e) {
            throw e;
        } finally {
            GlobalContextHolder.resetContext();
        }

    }

}
