package com.fishep.isc.server.interfaces.dubbo;

import com.fishep.common.context.GlobalContextHolder;
import com.fishep.isc.common.interfaces.ContextUserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/18 17:49
 * @Desc
 **/
@DubboService
public class ContextUserServiceImpl implements ContextUserService {

    @Override
    public List<String> permissions() {

        HashMap<String, String> hashMap = new HashMap<>();
        GlobalContextHolder.load(hashMap::put);
        System.out.println(hashMap);

        LinkedList<String> list = new LinkedList<>();
        list.add("demo.permission.roles");
        list.add("demo.permission.roles.all");
        list.add("demo.permission.permissions");
        list.add("demo.permission.permissions.all");

        return list;
    }

}
