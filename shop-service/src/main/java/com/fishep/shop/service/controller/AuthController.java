package com.fishep.shop.service.controller;

import com.fishep.sso.common.interfaces.AuthService;
import com.fishep.sso.common.interfaces.to.CheckTo;
import com.fishep.sso.common.interfaces.to.RegisterTo;
import com.fishep.sso.common.interfaces.vo.TokenVo;
import com.fishep.sso.common.interfaces.vo.UserVo;
import com.fishep.sso.starter.feign.AuthFeign;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2024/2/28 14:49
 * @Desc
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @DubboReference
    private AuthService authService;

    @Autowired
    private AuthFeign authFeign;

    @PostMapping("/registerByFeign")
    public TokenVo registerByFeign(@RequestBody RegisterTo registerTo) {
        return authFeign.register(registerTo);
    }

    @PostMapping("/registerByDubbo")
    public TokenVo registerByDubbo(@RequestBody RegisterTo registerTo) {
        return authService.register(registerTo);
    }

    @PostMapping("/checkByFeign")
    public UserVo checkByFeign(@RequestBody CheckTo checkTo) {
        return authFeign.check(checkTo);
    }

    @PostMapping("/checkByDubbo")
    public UserVo checkByDubbo(@RequestBody CheckTo checkTo) {
        return authService.check(checkTo);
    }

}
