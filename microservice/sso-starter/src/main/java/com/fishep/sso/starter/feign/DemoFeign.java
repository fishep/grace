package com.fishep.sso.starter.feign;

import com.fishep.sso.common.interfaces.DemoService;
import com.fishep.sso.starter.feign.impl.DemoFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author fly.fei
 * @Date 2024/3/5 16:09
 * @Desc
 **/
@FeignClient(value = "sso-server", contextId = "demo", fallback = DemoFeignImpl.class)
public interface DemoFeign extends DemoService {

    //    @GetMapping(value = "/api/demo/sayHello",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/api/demo/sayHello")
    String sayHello(@RequestParam String name);

}
