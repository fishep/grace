package com.fishep.sso.server.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author fly.fei
 * @Date 2024/3/11 15:28
 * @Desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    public Long id;

    public String name;

    public String type;

}
