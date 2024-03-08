package com.fishep.sso.common.interfaces;

import com.fishep.common.type.Result;
import com.fishep.sso.common.interfaces.to.RegisterTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;

/**
 * @Author fly.fei
 * @Date 2024/3/8 10:27
 * @Desc
 **/
public interface AuthService {

    Result<TokenVO> register(RegisterTO registerTO);

}
