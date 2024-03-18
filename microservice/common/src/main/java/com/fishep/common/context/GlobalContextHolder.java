package com.fishep.common.context;

import com.fishep.common.dp.Id;
import com.fishep.common.dp.Name;
import com.fishep.common.dp.Platform;
import com.fishep.common.dp.User;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author fly.fei
 * @Date 2024/3/12 17:24
 * @Desc
 **/
public class GlobalContextHolder {

    public static void setPlatform(Platform entity) {
        PlatformContextHolder.setEntity(entity);
    }

    public static Platform getPlatform() {
        return PlatformContextHolder.getEntity();
    }

    public static void setUser(User entity) {
        UserContextHolder.setEntity(entity);
    }

    public static User getUser() {
        return UserContextHolder.getEntity();
    }

    public static void resetContext() {
        PlatformContextHolder.resetContext();
        UserContextHolder.resetContext();
    }

    public static <T> void load(BiFunction<String, String, T> loader) {
        Platform platform = getPlatform();
        if (platform != null) {
            loader.apply(GlobalContextKey.PLATFORM, GlobalContextHolder.getPlatform().getType().name());
        }

        User user = getUser();
        if (user != null) {
            loader.apply(GlobalContextKey.USER_TYPE, user.getType().name());
            loader.apply(GlobalContextKey.USER_ID, String.valueOf(user.getId().getValue()));
            loader.apply(GlobalContextKey.USER_NAME, user.getName().getValue());
        }
    }

    public static void unload(Function<String, String> loader) {
        String platform = loader.apply(GlobalContextKey.PLATFORM);
        if (platform != null) {
            setPlatform(new Platform(Platform.Type.valueOf(platform)));
        }

        String userType = loader.apply(GlobalContextKey.USER_TYPE);
        String userId = loader.apply(GlobalContextKey.USER_ID);
        String userName = loader.apply(GlobalContextKey.USER_NAME);
        if (userType != null && userId != null && userName != null) {
            setUser(new User(new Id(Long.valueOf(userId)), new Name(userName), User.Type.valueOf(userType)));
        }
    }

}
