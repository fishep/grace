package com.fishep.sso.starter.feign.impl;

import com.fishep.common.type.Result;
import com.fishep.sso.starter.feign.DemoFeign;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.fishep.common.type.Message.FALLBACK;
import static com.fishep.common.type.Message.__;

/**
 * @Author fly.fei
 * @Date 2024/3/5 16:12
 * @Desc
 **/
@Component
public class DemoFeignImpl implements DemoFeign {

    @Override
    public String sayHelloByFeign(String name) {
        return __(FALLBACK, "DemoFeignImpl sayHelloByFeign name: " + name);
    }

    @Override
    public Result<String> sayThankByFeign(String name) {
        return Result.failure(__(FALLBACK, "sayThankByFeign name: " + name), null);
    }

    @Override
    public Result<String> exceptionByFeign() {
        return Result.failure(__(FALLBACK, "exceptionByFeign"), null);
    }

    @Override
    public Result<Map<String, Object>> contextByFeign() {
        return Result.failure(__(FALLBACK, "contextByFeign"), null);
    }

}
