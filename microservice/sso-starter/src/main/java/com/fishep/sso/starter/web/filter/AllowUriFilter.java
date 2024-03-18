package com.fishep.sso.starter.web.filter;

import com.fishep.common.context.GlobalContextHolder;
import com.fishep.common.exception.ServiceError;
import com.fishep.sso.starter.component.AllowUri;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.fishep.sso.common.type.Message.ACCESS_DENIED;
import static com.fishep.sso.common.type.Message.__;

/**
 * @Author fly.fei
 * @Date 2024/3/7 17:15
 * @Desc
 **/
//@Order(1)
//@Component
public class AllowUriFilter extends HttpFilter {

    //    @Autowired
    private AllowUri allowUri;

    public AllowUriFilter(AllowUri allowUri) {
        this.allowUri = allowUri;
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("AllowUriFilter Thread:" + Thread.currentThread().getName());

        Boolean login = GlobalContextHolder.getUser() != null;

        Boolean allow = allowUri.allow(request.getRequestURI(), login);
        if (!allow) {
            throw new ServiceError(__(ACCESS_DENIED, request.getRequestURI(), login));
        }

        super.doFilter(request, response, chain);
    }

}
