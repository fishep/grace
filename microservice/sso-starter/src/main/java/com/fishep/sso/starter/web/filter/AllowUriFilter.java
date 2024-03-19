package com.fishep.sso.starter.web.filter;

import com.fishep.common.context.GlobalContextHolder;
import com.fishep.common.exception.ServiceError;
import com.fishep.sso.starter.component.AllowUri;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.fishep.sso.common.type.Message.ACCESS_DENIED;
import static com.fishep.sso.common.type.Message.__;

/**
 * @Author fly.fei
 * @Date 2024/3/7 17:15
 * @Desc
 **/
@Slf4j
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

        log.trace("doFilter, RequestId is " + request.getRequestId());

        Boolean login = GlobalContextHolder.getUser() != null;

        Boolean allow = allowUri.allow(request.getRequestURI(), login);
        if (!allow) {
            throw new ServiceError(__(ACCESS_DENIED, request.getRequestURI(), login));
        }

        super.doFilter(request, response, chain);
    }

}
