package com.fishep.sso.starter.web.filter;

import com.fishep.common.context.UserContextHolder;
import com.fishep.common.dp.Id;
import com.fishep.common.dp.Name;
import com.fishep.common.dp.User;
import com.fishep.sso.common.interfaces.AuthService;
import com.fishep.sso.common.interfaces.to.CheckTO;
import com.fishep.sso.common.interfaces.vo.UserVO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

import java.io.IOException;

/**
 * @Author fly.fei
 * @Date 2024/3/7 17:15
 * @Desc
 **/
@Slf4j
//@Order(0)
//@Component
public class AuthFilter extends HttpFilter {

    private AuthService authService;

    public AuthFilter(AuthService authService) {
        this.authService = authService;
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.trace("doFilter, RequestId is " + request.getRequestId());

        String token = getToken(request);
        User user = getUser(token);

        try {
            UserContextHolder.setEntity(user);
            super.doFilter(request, response, chain);
        } catch (Exception e) {
            throw e;
        } finally {
            UserContextHolder.resetContext();
        }
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token == null || token.isEmpty()) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(HttpHeaders.AUTHORIZATION)) {
                        token = cookie.getValue();
                        break;
                    }
                }
            }
        }

        if (token == null || token.isEmpty()) {
            token = request.getParameter(HttpHeaders.AUTHORIZATION);
        }

        return token;
    }

    private User getUser(String token) {
        if (!(token == null || token.isEmpty())) {
            UserVO userVO = authService.check(new CheckTO(token));
            if (userVO != null) {
                return new User(new Id(userVO.getId()), new Name(userVO.getName()), User.Type.valueOf(userVO.getType()));
            }
        }

        return null;
    }

}
