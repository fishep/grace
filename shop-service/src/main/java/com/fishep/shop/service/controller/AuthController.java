package com.fishep.shop.service.controller;

import com.fishep.sso.common.interfaces.AuthService;
import com.fishep.sso.common.interfaces.to.CheckTO;
import com.fishep.sso.common.interfaces.to.RegisterTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;
import com.fishep.sso.common.interfaces.vo.UserVO;
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
    public TokenVO registerByFeign(@RequestBody RegisterTO registerTO) {
        return authFeign.register(registerTO);
    }

    @PostMapping("/registerByDubbo")
    public TokenVO registerByDubbo(@RequestBody RegisterTO registerTO) {
        return authService.register(registerTO);
    }

    @PostMapping("/checkByFeign")
    public UserVO checkByFeign(@RequestBody CheckTO checkTO) {
        return authFeign.check(checkTO);
    }

    @PostMapping("/checkByDubbo")
    public UserVO checkByDubbo(@RequestBody CheckTO checkTO) {
        return authService.check(checkTO);
    }

}
