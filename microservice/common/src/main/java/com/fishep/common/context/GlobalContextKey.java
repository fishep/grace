package com.fishep.common.context;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/3/13 15:53
 * @Desc
 **/
public final class GlobalContextKey {
    public static final String PLATFORM = "G-Platform";
    public static final String USER_TYPE = "G-User-Type";
    public static final String USER_ID = "G-User-Id";
    public static final String USER_NAME = "G-User-Name";
//    public static final String LOCALE = "G-Locale";

    public static List<String> getKeys() {
        List<String> keys = new ArrayList<>();

        Field[] fields = GlobalContextKey.class.getFields();
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
