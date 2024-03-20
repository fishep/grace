package com.fishep.isc.starter.aspect;

import com.fishep.common.context.GlobalContextHolder;
import com.fishep.common.dp.User;
import com.fishep.common.exception.ServiceException;
import com.fishep.isc.common.interfaces.ContextUserService;
import com.fishep.isc.starter.annotation.Permission;
import com.fishep.isc.starter.annotation.Permissions;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.fishep.isc.common.type.Message.*;

/**
 * @Author fly.fei
 * @Date 2024/3/18 14:56
 * @Desc 从服务端获取当前登录用户的所有权限，客户端校验
 **/
@Slf4j
//@Aspect
//@Component
public class ContextUserPermissionClientCheckAspect {

    private ContextUserService contextUserService;

    @Autowired
    public ContextUserPermissionClientCheckAspect(ContextUserService contextUserService) {
        assert contextUserService != null;
        this.contextUserService = contextUserService;
    }

    @Before("@annotation(permission)")
    public void permission(Permission permission) {
        check(permission);
    }

    @Before("@within(permission)")
    public void withinPermission(Permission permission) {
        check(permission);
    }

    @Before("@annotation(permissions)")
    public void permissions(Permissions permissions) {
        check(permissions);
    }

    @Before("@within(permissions)")
    public void withinPermissions(Permissions permissions) {
        check(permissions);
    }

    private void check(Permissions permissions) {
        List<String> ps = contextUserPermissions();

        if (permissions.value().length > 0) {
            for (Permission p : permissions.value()) {
                doCheck(p.value(), ps);
            }
        }

        if (permissions.values().length > 0) {
            for (String p : permissions.values()) {
                doCheck(p, ps);
            }
        }
    }

    private void check(Permission permission) {
        doCheck(permission.value(), contextUserPermissions());
    }

    private void doCheck(String permission, List<String> permissions) {
        if (!permissions.contains(permission)) {
            throw new ServiceException(__(REQUIRED_PERMISSION, permission));
        }
    }

    private List<String> contextUserPermissions() {

        log.trace("contextUserPermissions");

        User user = GlobalContextHolder.getUser();
        if (user == null) {
            throw new ServiceException(__(REQUIRED_USER));
        }

        // @TODO 客户端获取了所有的权限，应该缓存
        return contextUserService.permissions();
    }

}
