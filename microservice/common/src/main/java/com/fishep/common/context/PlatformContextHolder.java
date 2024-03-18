package com.fishep.common.context;

import com.fishep.common.dp.Platform;
import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.core.NamedThreadLocal;

/**
 * @Author fly.fei
 * @Date 2024/3/8 16:30
 * @Desc
 **/
public final class PlatformContextHolder {

    private static final ThreadLocal<Context<Platform>> holder = new NamedThreadLocal<>("PlatformContextHolder");

    private static final ThreadLocal<Context<Platform>> inheritableHolder = new NamedInheritableThreadLocal<>("PlatformContextHolder");

    private PlatformContextHolder() {
    }

    public static void resetContext() {
        holder.remove();
        inheritableHolder.remove();
    }

    public static void setContext(Context<Platform> context) {
        setContext(context, false);
    }

    public static void setContext(Context<Platform> context, boolean inheritable) {
        if (context == null) {
            resetContext();
        } else {
            if (inheritable) {
                holder.remove();
                inheritableHolder.set(context);
            } else {
                holder.set(context);
                inheritableHolder.remove();
            }
        }
    }

    public static Context<Platform> getContext() {
        Context<Platform> context = holder.get();
        if (context == null) {
            context = inheritableHolder.get();
        }
        return context;
    }

    public static void setEntity(Platform entity) {
        setEntity(entity, false);
    }

    public static void setEntity(Platform entity, boolean inheritable) {
        Context<Platform> context;
        if (entity != null) {
            context = new SimpleContext<>(entity);
        } else {
            context = null;
        }
        setContext(context, inheritable);
    }

    public static Platform getEntity() {
        return getEntity(getContext());
    }

    public static Platform getEntity(Context<Platform> context) {
        if (context != null) {
            return context.getEntity();
        }
        return null;
    }

}
