package com.fishep.isc.server.interfaces.dubbo;

import com.fishep.isc.common.interfaces.PermissionService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/18 18:28
 * @Desc
 **/
@DubboService
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<String> roles() {
        LinkedList<String> list = new LinkedList<>();
        list.add("role1");
        list.add("role2");
        list.add("role3");
        list.add("demo.permission.roles");
        list.add("demo.permission.roles.all");

        return list;
    }

    @Override
    public List<String> permissions() {
        LinkedList<String> list = new LinkedList<>();
        list.add("permission1");
        list.add("permission2");
        list.add("permission3");
        list.add("demo.permission.permissions");
        list.add("demo.permission.permissions.all");

        return list;
    }
}
