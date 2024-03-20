package com.fishep.sso.server.interfaces.controller;

import com.fishep.sso.common.interfaces.to.CheckTo;
import com.fishep.sso.common.interfaces.to.RegisterTo;
import com.fishep.sso.common.interfaces.vo.TokenVo;
import com.fishep.sso.common.interfaces.vo.UserVo;
import com.fishep.sso.server.application.cqe.CheckCommand;
import com.fishep.sso.server.application.cqe.RegisterCommand;
import com.fishep.sso.server.application.dto.TokenDto;
import com.fishep.sso.server.application.dto.UserDto;
import com.fishep.sso.server.application.service.AuthServer;
import com.fishep.sso.server.interfaces.converter.TokenConverter;
import com.fishep.sso.server.interfaces.converter.UserConverter;
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

    private final AuthServer authServer;

    private final TokenConverter tokenConverter = TokenConverter.INSTANCE;

    private final UserConverter userConverter = UserConverter.INSTANCE;

    @Autowired
    public AuthController(AuthServer authServer) {
        this.authServer = authServer;
    }

    @PostMapping("/register")
    public TokenVo register(@RequestBody RegisterTo registerTo) {

        TokenDto dto = authServer.register(new RegisterCommand());

        TokenVo tokenVo = tokenConverter.toTokenVo(dto);

        return tokenVo;
    }

    @PostMapping("/check")
    public UserVo check(@RequestBody CheckTo checkTo) {

        UserDto userDto = authServer.check(new CheckCommand());

        UserVo userVo = userConverter.toUserVo(userDto);

        return userVo;
    }

}
