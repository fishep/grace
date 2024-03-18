package com.fishep.server.web.filter;

import com.fishep.common.context.GlobalContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author fly.fei
 * @Date 2024/3/7 17:15
 * @Desc 服务端接收全局上下文，客户端传递 {@link FeignInterceptor}
 **/
@WebFilter
public class GlobalContextFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Web GlobalContextFilter Thread:" + Thread.currentThread().getName());

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
