package com.fishep.back.service.controller;

import com.fishep.common.type.Result;
import com.fishep.sso.common.interfaces.AuthService;
import com.fishep.sso.common.interfaces.to.RegisterTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;
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
    private AuthService authFeign;

    @PostMapping("/register/byFeign")
    public Result<TokenVO> registerByFeign(@RequestBody RegisterTO registerTO) {
        return authFeign.register(registerTO);
    }

    @PostMapping("/register/ByDubbo")
    public Result<TokenVO> registerByDubbo(@RequestBody RegisterTO registerTO) {
        return authService.register(registerTO);
    }

}
