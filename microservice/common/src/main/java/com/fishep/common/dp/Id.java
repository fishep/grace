package com.fishep.common.dp;

import cn.hutool.core.util.IdUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/3/8 16:39
 * @Desc
 **/
@Data
@AllArgsConstructor
public class Id {

    protected Long value;

    public Id() {
        this(IdUtil.getSnowflakeNextId());
    }

}
