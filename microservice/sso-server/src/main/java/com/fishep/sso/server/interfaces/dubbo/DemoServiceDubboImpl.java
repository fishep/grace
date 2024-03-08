package com.fishep.sso.server.interfaces.dubbo;

import com.fishep.sso.common.interfaces.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Author fly.fei
 * @Date 2024/3/8 11:09
 * @Desc
 **/
@DubboService
public class DemoServiceDubboImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

}
