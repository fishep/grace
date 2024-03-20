package com.fishep.back.service.controller.demo;

import com.fishep.isc.common.interfaces.PermissionService;
import com.fishep.isc.starter.annotation.Permission;
import com.fishep.isc.starter.annotation.Permissions;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/18 18:08
 * @Desc
 **/
@RestController
@RequestMapping("/demo/permission")
public class PermissionController {

    @DubboReference
    private PermissionService permissionService;

    @GetMapping("/roles")
    @Permission("demo.permission.roles")
    @Permission("demo.permission.roles.all")
    public List<String> roles() {
        List<String> roles = permissionService.roles();
        return roles;
    }

    @GetMapping("/permissions")
    @Permissions(values = {"demo.permission.permissions", "demo.permission.permissions.all"})
    public List<String> permissions() {
        List<String> permissions = permissionService.permissions();
        return permissions;
    }

    @GetMapping("/reject")
    @Permission("demo.permission.permissions")
    @Permission("demo.permission.permissions.reject")
    public String reject() {
        return "accept";
    }

}
