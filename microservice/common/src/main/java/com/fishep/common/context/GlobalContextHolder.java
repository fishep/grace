package com.fishep.common.context;

import cn.hutool.json.JSONUtil;
import com.fishep.common.dp.Id;
import com.fishep.common.dp.Name;
import com.fishep.common.dp.Platform;
import com.fishep.common.dp.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
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
            loader.apply(Loader.PLATFORM, JSONUtil.toJsonStr(platform));
        }

        User user = getUser();
        if (user != null) {
            loader.apply(Loader.USER, JSONUtil.toJsonStr(user));
        }
    }

    public static void unload(Function<String, String> loader) {

        String platform = loader.apply(Loader.PLATFORM);
        if (platform != null) {
            setPlatform(JSONUtil.toBean(platform, Platform.class));
        }

        String user = loader.apply(Loader.USER);
        if (user != null) {
            setUser(JSONUtil.toBean(user, User.class));
        }
    }

    /**
     * @Author fly.fei
     * @Date 2024/3/13 15:53
     * @Desc
     **/
    public static final class Loader {
        public static final String PLATFORM = Platform.class.getSimpleName();
        public static final String USER = User.class.getSimpleName();

        public static List<String> getKeys() {
            List<String> keys = new ArrayList<>();

            Field[] fields = Loader.class.getFields();
            for (Field field : fields) {
                if (field.getType().equals(String.class) && Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
                    try {
                        Object value = field.get(null);
                        if (value instanceof String) {
                            keys.add((String) value);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            return keys;
        }

    }
}
