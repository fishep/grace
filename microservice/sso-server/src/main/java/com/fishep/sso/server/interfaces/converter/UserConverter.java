package com.fishep.sso.server.interfaces.converter;

import com.fishep.sso.common.interfaces.vo.UserVO;
import com.fishep.sso.server.application.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author fly.fei
 * @Date 2024/3/11 15:40
 * @Desc
 **/
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserVO toUserVo(UserDTO userDTO);

}
