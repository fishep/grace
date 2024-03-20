package com.fishep.isc.server.interfaces.dubbo;

import com.fishep.common.context.GlobalContextHolder;
import com.fishep.isc.common.interfaces.ContextUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/18 17:49
 * @Desc
 **/
@Slf4j
@DubboService
public class ContextUserServiceImpl implements ContextUserService {

    @Override
    public List<String> permissions() {

        HashMap<String, String> hashMap = new HashMap<>();
        GlobalContextHolder.load(hashMap::put);
        log.trace(hashMap.toString());

        LinkedList<String> list = new LinkedList<>();
        list.add("demo.permission.roles");
        list.add("demo.permission.roles.all");
        list.add("demo.permission.permissions");
        list.add("demo.permission.permissions.all");

        return list;
    }

    @Override
    public Boolean have(String permission) {

        if (permission.equals("demo.permission.permissions.reject")) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}
