package com.fishep.sso.server.application.service.impl;

import com.fishep.sso.server.application.cqe.CheckCommand;
import com.fishep.sso.server.application.cqe.RegisterCommand;
import com.fishep.sso.server.application.dto.TokenDTO;
import com.fishep.sso.server.application.dto.UserDTO;
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
    public TokenDTO register(RegisterCommand registerCommand) {
        return new TokenDTO(1L, "helloToken");
    }

    @Override
    public UserDTO check(CheckCommand checkCommand) {
        return new UserDTO(1L, "root", "ADMIN");
    }

}
