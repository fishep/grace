package com.fishep.sso.server.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author fly.fei
 * @Date 2024/2/28 11:44
 * @Desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {

    public Long userId;

    public String token;

}
