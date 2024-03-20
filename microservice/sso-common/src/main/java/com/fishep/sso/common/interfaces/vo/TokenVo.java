package com.fishep.sso.common.interfaces.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author fly.fei
 * @Date 2024/2/29 11:26
 * @Desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenVo implements Serializable {

    public Long userId;

    public String token;

}
