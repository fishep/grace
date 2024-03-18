package com.fishep.common.dp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/3/8 16:39
 * @Desc
 **/
@Data
@AllArgsConstructor
public class User {

    protected Id id;

    protected Name name;

    protected Type type;

    public enum Type {
        ADMIN,    // 管理员，公司内部用户
        CUSTOMER, // 客户，任何在商城注册的用户
        SUPPLIER  // 供应商，公司的供应商
    }

}
