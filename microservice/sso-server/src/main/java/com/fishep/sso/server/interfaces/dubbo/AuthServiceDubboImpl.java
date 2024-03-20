package com.fishep.sso.server.interfaces.dubbo;

import com.fishep.sso.common.interfaces.AuthService;
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
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author fly.fei
 * @Date 2024/3/8 11:03
 * @Desc
 **/
@DubboService
public class AuthServiceDubboImpl implements AuthService {

    private final AuthServer authServer;

    private final TokenConverter tokenConverter = TokenConverter.INSTANCE;

    private final UserConverter userConverter = UserConverter.INSTANCE;

    @Autowired
    public AuthServiceDubboImpl(AuthServer authServer) {
        this.authServer = authServer;
    }

    @Override
    public TokenVo register(RegisterTo registerTo) {

        TokenDto dto = authServer.register(new RegisterCommand());

        TokenVo tokenVo = tokenConverter.toTokenVo(dto);

        return tokenVo;
    }

    @Override
    public UserVo check(CheckTo checkTo) {

        UserDto userDto = authServer.check(new CheckCommand());

        UserVo userVo = userConverter.toUserVo(userDto);

        return userVo;
    }

}
