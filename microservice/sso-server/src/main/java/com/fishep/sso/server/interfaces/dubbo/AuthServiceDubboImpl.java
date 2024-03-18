package com.fishep.sso.server.interfaces.dubbo;

import com.fishep.sso.common.interfaces.AuthService;
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
    public TokenVO register(RegisterTO registerTO) {

        TokenDTO dto = authServer.register(new RegisterCommand());

        TokenVO tokenVO = tokenConverter.toTokenVo(dto);

        return tokenVO;
    }

    @Override
    public UserVO check(CheckTO checkTO) {

        UserDTO userDTO = authServer.check(new CheckCommand());

        UserVO userVO = userConverter.toUserVo(userDTO);

        return userVO;
    }

}
