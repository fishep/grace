package com.fishep.sso.server.interfaces.controller;

import com.fishep.sso.common.interfaces.to.CheckTO;
import com.fishep.sso.common.interfaces.to.RegisterTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;
import com.fishep.sso.common.interfaces.vo.UserVO;
import com.fishep.sso.server.application.cqe.CheckCommand;
import com.fishep.sso.server.application.cqe.RegisterCommand;
import com.fishep.sso.server.application.dto.TokenDTO;
import com.fishep.sso.server.application.dto.UserDTO;
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
    public TokenVO register(@RequestBody RegisterTO registerTO) {

        TokenDTO dto = authServer.register(new RegisterCommand());

        TokenVO tokenVO = tokenConverter.toTokenVo(dto);

        return tokenVO;
    }

    @PostMapping("/check")
    public UserVO check(@RequestBody CheckTO checkTO) {

        UserDTO userDTO = authServer.check(new CheckCommand());

        UserVO userVO = userConverter.toUserVo(userDTO);

        return userVO;
    }

}
