package com.fishep.shop.service.web.filter;

import com.fishep.common.context.GlobalContextHolder;
import com.fishep.common.dp.User;
import com.fishep.common.exception.ServiceError;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.fishep.common.type.Message.PROHIBIT_USER;
import static com.fishep.common.type.Message.__;


/**
 * @Author fly.fei
 * @Date 2024/3/12 16:08
 * @Desc
 **/
@Slf4j
@Component
public class ShopServiceFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.trace("doFilter, RequestId is " + request.getRequestId());

        User user = GlobalContextHolder.getUser();
        if (user != null && user.getType() != User.Type.CUSTOMER) {
            throw new ServiceError(__(PROHIBIT_USER, "ShopService", user.getType().name()));
        }

        super.doFilter(request, response, chain);
    }

}
