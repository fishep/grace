package com.fishep.isc.common.interfaces;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/18 14:56
 * @Desc
 **/
public interface ContextUserService {

    // 上下文用户（当前登录用户）的所有权限
    List<String> permissions();

    // 上下文用户（当前登录用户）是否有权限
    Boolean have(String permission);

}
