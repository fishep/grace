package com.fishep.sso.starter.feign.impl;

import com.fishep.sso.starter.feign.DemoFeign;
import org.springframework.stereotype.Component;

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
    public String sayHello(String name) {
        return __(FALLBACK, "DemoFeignImpl sayHello()");
    }

}
