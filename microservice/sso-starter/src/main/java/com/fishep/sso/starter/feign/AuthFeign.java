package com.fishep.sso.starter.feign;

import com.fishep.common.type.Result;
import com.fishep.sso.common.interfaces.AuthService;
import com.fishep.sso.common.interfaces.to.CheckTO;
import com.fishep.sso.common.interfaces.to.RegisterTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;
import com.fishep.sso.common.interfaces.vo.UserVO;
import com.fishep.sso.starter.feign.impl.AuthFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "sso-server", path = "/api/auth", contextId = "auth", fallback = AuthFeignImpl.class)
public interface AuthFeign extends AuthService {

    @PostMapping("/register")
    Result<TokenVO> registerByFeign(@RequestBody RegisterTO registerTO);

    @PostMapping("/check")
    Result<UserVO> checkByFeign(@RequestBody CheckTO checkTO);

    @Override
    default TokenVO register(RegisterTO registerTO) {
        Result<TokenVO> result = this.registerByFeign(registerTO);
        return result.getData();
    }

    @Override
    default UserVO check(CheckTO checkTO) {
        Result<UserVO> result = this.checkByFeign(checkTO);
        return result.getData();
    }

}
