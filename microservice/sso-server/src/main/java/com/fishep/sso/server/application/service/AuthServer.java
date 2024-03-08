package com.fishep.sso.server.application.service;

import com.fishep.sso.server.application.cqe.RegisterCommand;
import com.fishep.sso.server.application.dto.TokenDTO;

/**
 * @Author fly.fei
 * @Date 2024/2/21 18:31
 * @Desc
 **/
public interface AuthServer {

    TokenDTO register(RegisterCommand registerCommand);

//    TokenDTO login(LoginCommand loginCommand);
//
//    Boolean logout(LogoutCommand logoutCommand);
//
//    Boolean checkToken(CheckTokenCommand checkTokenCommand);
//
//    Boolean changePassword(ChangePasswordCommand changePasswordCommand);
//
//    Boolean verificationAccount(VerificationAccountCommand verificationAccountCommand);
//
//    Boolean cancelAccount(CancelAccountCommand cancelAccountCommand);

}
