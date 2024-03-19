package com.fishep.isc.common.interfaces;

import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/18 14:56
 * @Desc
 **/
public interface PermissionService {

//  获取所有的角色
    List<String> roles();

//  获取所有的权限
    List<String> permissions();

}
