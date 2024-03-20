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

import static com.fishep.isc.common.type.Message.*;

/**
 * @Author fly.fei
 * @Date 2024/3/18 14:56
 * @Desc 请求服务端校验当前登录用户的权限
 **/
@Slf4j
@Aspect
@Component
public class ContextUserPermissionServerCheckAspect {

    private ContextUserService contextUserService;

    @Autowired
    public ContextUserPermissionServerCheckAspect(ContextUserService contextUserService) {
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
        if (permissions.value().length > 0) {
            for (Permission p : permissions.value()) {
                doCheck(p.value());
            }
        }

        if (permissions.values().length > 0) {
            for (String p : permissions.values()) {
                doCheck(p);
            }
        }
    }

    private void check(Permission permission) {
        doCheck(permission.value());
    }

    private void doCheck(String permission) {

        if (!contextUserHavePermission(permission)) {
            throw new ServiceException(__(REQUIRED_PERMISSION, permission));
        }

    }

    private Boolean contextUserHavePermission(String permission) {

        log.trace("contextUserHavePermission: " + permission);

        User user = GlobalContextHolder.getUser();
        if (user == null) {
            throw new ServiceException(__(REQUIRED_USER));
        }

        return contextUserService.have(permission);
    }

}
