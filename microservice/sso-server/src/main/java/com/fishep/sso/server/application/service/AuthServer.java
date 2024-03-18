package com.fishep.sso.server.application.service;

import com.fishep.sso.server.application.cqe.CheckCommand;
import com.fishep.sso.server.application.cqe.RegisterCommand;
import com.fishep.sso.server.application.dto.TokenDTO;
import com.fishep.sso.server.application.dto.UserDTO;

/**
 * @Author fly.fei
 * @Date 2024/2/21 18:31
 * @Desc
 **/
public interface AuthServer {

    TokenDTO register(RegisterCommand registerCommand);

    UserDTO check(CheckCommand checkCommand);

}
