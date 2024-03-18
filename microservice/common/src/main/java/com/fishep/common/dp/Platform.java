package com.fishep.common.dp;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/3/12 17:27
 * @Desc
 **/
@Getter
@AllArgsConstructor
public class Platform {

    protected Type type;

    public enum Type {
        SHOP, // 商城
        BACK, // 后台
        OPEN  // 开放平台
    }

}
