package com.fishep.sso.common.interfaces;

import com.fishep.sso.common.interfaces.to.CheckTO;
import com.fishep.sso.common.interfaces.to.RegisterTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;
import com.fishep.sso.common.interfaces.vo.UserVO;

/**
 * @Author fly.fei
 * @Date 2024/3/8 10:27
 * @Desc
 **/
public interface AuthService {

    TokenVO register(RegisterTO registerTO);

    UserVO check(CheckTO checkTO);

}
