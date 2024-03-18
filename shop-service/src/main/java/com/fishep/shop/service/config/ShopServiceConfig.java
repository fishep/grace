package com.fishep.shop.service.config;

import com.fishep.common.context.PlatformContextHolder;
import com.fishep.common.dp.Platform;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fly.fei
 * @Date 2024/3/13 15:18
 * @Desc
 **/
@Configuration
public class ShopServiceConfig {

    @PostConstruct
    private void init() {
        PlatformContextHolder.setEntity(new Platform(Platform.Type.SHOP), true);
    }

}
