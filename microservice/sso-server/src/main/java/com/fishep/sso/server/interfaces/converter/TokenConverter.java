package com.fishep.sso.server.interfaces.converter;

import com.fishep.sso.server.application.dto.TokenDTO;
import com.fishep.sso.common.interfaces.vo.TokenVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author fly.fei
 * @Date 2024/2/29 12:18
 * @Desc
 **/
@Mapper
public interface TokenConverter {

    TokenConverter INSTANCE = Mappers.getMapper(TokenConverter.class);

//    @Mapping(target = "seatCount", source = "numberOfSeats")
    TokenVO dtoToVo(TokenDTO tokenDTO);

}
