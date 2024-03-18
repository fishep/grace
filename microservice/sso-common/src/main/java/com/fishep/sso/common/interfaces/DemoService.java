package com.fishep.sso.common.interfaces;

import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/3/1 14:24
 * @Desc
 **/
public interface DemoService {

    String sayHello(String name);

    String sayThank(String name);

    String exception();

    Map<String, Object> context();

}
