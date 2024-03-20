package com.fishep.sso.starter.feign.impl;

import com.fishep.common.type.Result;
import com.fishep.sso.common.interfaces.to.CheckTo;
import com.fishep.sso.common.interfaces.to.RegisterTo;
import com.fishep.sso.common.interfaces.vo.TokenVo;
import com.fishep.sso.common.interfaces.vo.UserVo;
import com.fishep.sso.starter.feign.AuthFeign;
import org.springframework.stereotype.Component;

import static com.fishep.common.type.Message.FALLBACK;
import static com.fishep.common.type.Message.__;

@Component
public class AuthFeignImpl implements AuthFeign {

    @Override
    public Result<TokenVo> registerByFeign(RegisterTo registerTo) {
        return Result.failure(__(FALLBACK, "registerTo: " + registerTo), null);
    }

    @Override
    public Result<UserVo> checkByFeign(CheckTo checkTo) {
        return Result.failure(__(FALLBACK, "checkTo: " + checkTo), null);
    }

}
