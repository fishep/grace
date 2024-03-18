package com.fishep.sso.starter.feign;

import com.fishep.common.type.Result;
import com.fishep.sso.common.interfaces.DemoService;
import com.fishep.sso.starter.feign.impl.DemoFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/3/5 16:09
 * @Desc
 **/
@FeignClient(value = "sso-server", path = "/api/demo", contextId = "demo", fallback = DemoFeignImpl.class)
public interface DemoFeign extends DemoService {

    //    //    @GetMapping(value = "/sayHello",
////            consumes = MediaType.APPLICATION_JSON_VALUE,
////            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/sayHello")
    String sayHelloByFeign(@RequestParam String name);

    @GetMapping(value = "/sayThank")
    Result<String> sayThankByFeign(@RequestParam String name);

    @GetMapping("/exception")
    Result<String> exceptionByFeign();

    @GetMapping("/context")
    Result<Map<String, Object>> contextByFeign();

    @Override
    default String sayHello(String name) {
        return this.sayHelloByFeign(name);
    }

    @Override
    default String sayThank(String name) {
        return this.sayThankByFeign(name).getData();
    }

    @Override
    default String exception() {
        return this.exceptionByFeign().getData();
    }

    @Override
    default Map<String, Object> context() {
        return this.contextByFeign().getData();
    }

}
