package com.fishep.sso.common.interfaces;

import com.fishep.sso.common.interfaces.to.CheckTo;
import com.fishep.sso.common.interfaces.to.RegisterTo;
import com.fishep.sso.common.interfaces.vo.TokenVo;
import com.fishep.sso.common.interfaces.vo.UserVo;

/**
 * @Author fly.fei
 * @Date 2024/3/8 10:27
 * @Desc
 **/
public interface AuthService {

    TokenVo register(RegisterTo registerTo);

    UserVo check(CheckTo checkTo);

}
