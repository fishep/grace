package com.fishep.back.service.controller.demo;

import com.fishep.isc.common.interfaces.ContextUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/18 18:08
 * @Desc
 **/
@RestController
@RequestMapping("/demo/contextUser")
public class ContextUserController {

    @DubboReference
    private ContextUserService contextUserService;

    @GetMapping("/permissions")
    public List<String> permissions() {
        List<String> permissions = contextUserService.permissions();
        return permissions;
    }

    @GetMapping("/permissionCheck")
    public Boolean permissionCheck(@RequestParam String permission) {
        return contextUserService.have(permission);
    }

}