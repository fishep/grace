package com.fishep.sso.starter.feign.impl;

import com.fishep.common.type.Result;
import com.fishep.sso.common.interfaces.to.RegisterTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;
import com.fishep.sso.starter.feign.AuthFeign;
import org.springframework.stereotype.Component;

import static com.fishep.common.type.Message.FALLBACK;
import static com.fishep.common.type.Message.__;

@Component
public class AuthFeignImpl implements AuthFeign {

    @Override
    public Result<TokenVO> register(RegisterTO registerTO) {
        return Result.failure(__(FALLBACK, "registerTO: " + registerTO), null);
    }

}