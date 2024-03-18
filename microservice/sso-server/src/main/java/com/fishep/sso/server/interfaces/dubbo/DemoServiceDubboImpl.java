package com.fishep.sso.server.interfaces.dubbo;

import com.fishep.common.context.GlobalContextHolder;
import com.fishep.common.exception.ServiceException;
import com.fishep.sso.common.interfaces.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/3/8 11:09
 * @Desc
 **/
@DubboService
public class DemoServiceDubboImpl implements DemoService {

    @Override
    public String sayHello(String name) {

        System.out.println("DemoServiceDubboImpl sayHello Thread:" + Thread.currentThread().getName());

        return "hello " + name;
    }

    @Override
    public String sayThank(String name) {
        return "thank " + name;
    }

    @Override
    public String exception() {
        throw new ServiceException("sso DemoServiceDubboImpl exception");
    }

    @Override
    public Map<String, Object> context() {
        HashMap<String, Object> map = new HashMap<>();

        GlobalContextHolder.load(map::put);

        return map;
    }

}
