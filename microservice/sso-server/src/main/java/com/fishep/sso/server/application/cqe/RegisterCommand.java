package com.fishep.sso.server.application.cqe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author fly.fei
 * @Date 2024/2/28 11:40
 * @Desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCommand {

    private String name;

}
