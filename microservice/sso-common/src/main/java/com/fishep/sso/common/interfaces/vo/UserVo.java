package com.fishep.sso.common.interfaces.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author fly.fei
 * @Date 2024/3/11 16:04
 * @Desc
 **/
@Data
public class UserVo implements Serializable {

    public Long id;

    public String name;

    public String type;

}
