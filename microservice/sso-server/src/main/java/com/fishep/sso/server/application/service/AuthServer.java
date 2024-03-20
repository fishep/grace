package com.fishep.sso.server.application.service;

import com.fishep.sso.server.application.cqe.CheckCommand;
import com.fishep.sso.server.application.cqe.RegisterCommand;
import com.fishep.sso.server.application.dto.TokenDto;
import com.fishep.sso.server.application.dto.UserDto;

/**
 * @Author fly.fei
 * @Date 2024/2/21 18:31
 * @Desc
 **/
public interface AuthServer {

    TokenDto register(RegisterCommand registerCommand);

    UserDto check(CheckCommand checkCommand);

}
