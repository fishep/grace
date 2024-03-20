package com.fishep.sso.common.interfaces.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author fly.fei
 * @Date 2024/3/11 16:03
 * @Desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckTo implements Serializable {

    public String token;

}
