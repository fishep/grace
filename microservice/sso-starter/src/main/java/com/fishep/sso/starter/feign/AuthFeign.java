package com.fishep.sso.starter.feign;

import com.fishep.common.type.Result;
import com.fishep.sso.common.interfaces.AuthService;
import com.fishep.sso.common.interfaces.to.CheckTo;
import com.fishep.sso.common.interfaces.to.RegisterTo;
import com.fishep.sso.common.interfaces.vo.TokenVo;
import com.fishep.sso.common.interfaces.vo.UserVo;
import com.fishep.sso.starter.feign.impl.AuthFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "sso-server", path = "/api/auth", contextId = "auth", fallback = AuthFeignImpl.class)
public interface AuthFeign extends AuthService {

    @PostMapping("/register")
    Result<TokenVo> registerByFeign(@RequestBody RegisterTo registerTo);

    @PostMapping("/check")
    Result<UserVo> checkByFeign(@RequestBody CheckTo checkTo);

    @Override
    default TokenVo register(RegisterTo registerTo) {
        Result<TokenVo> result = this.registerByFeign(registerTo);
        return result.getData();
    }

    @Override
    default UserVo check(CheckTo checkTo) {
        Result<UserVo> result = this.checkByFeign(checkTo);
        return result.getData();
    }

}
