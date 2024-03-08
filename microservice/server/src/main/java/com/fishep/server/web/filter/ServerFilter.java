package com.fishep.server.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @Author fly.fei
 * @Date 2024/3/7 17:15
 * @Desc
 **/
@WebFilter
public class ServerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("ServerFilter doFilter before");

        chain.doFilter(request, response);

        System.out.println("ServerFilter doFilter after");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
