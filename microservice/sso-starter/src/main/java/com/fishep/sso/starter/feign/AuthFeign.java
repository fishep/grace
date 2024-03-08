package com.fishep.sso.starter.feign;

import com.fishep.common.type.Result;
import com.fishep.sso.common.interfaces.AuthService;
import com.fishep.sso.common.interfaces.to.RegisterTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;
import com.fishep.sso.starter.feign.impl.AuthFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "sso-server", contextId = "auth", fallback = AuthFeignImpl.class)
public interface AuthFeign extends AuthService {

    @PostMapping("/api/auth/register")
    Result<TokenVO> register(@RequestBody RegisterTO registerTO);

}
