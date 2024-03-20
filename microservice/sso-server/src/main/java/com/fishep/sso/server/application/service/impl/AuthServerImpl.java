package com.fishep.sso.server.application.service.impl;

import com.fishep.sso.server.application.cqe.CheckCommand;
import com.fishep.sso.server.application.cqe.RegisterCommand;
import com.fishep.sso.server.application.dto.TokenDto;
import com.fishep.sso.server.application.dto.UserDto;
import com.fishep.sso.server.application.service.AuthServer;
import org.springframework.stereotype.Component;

/**
 * @Author fly.fei
 * @Date 2024/2/28 14:38
 * @Desc
 **/
@Component
public class AuthServerImpl implements AuthServer {

    @Override
    public TokenDto register(RegisterCommand registerCommand) {
        return new TokenDto(1L, "helloToken");
    }

    @Override
    public UserDto check(CheckCommand checkCommand) {
        return new UserDto(1L, "root", "ADMIN");
    }

}
