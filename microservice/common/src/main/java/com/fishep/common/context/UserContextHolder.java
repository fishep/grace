package com.fishep.common.context;

import com.fishep.common.dp.User;
import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.core.NamedThreadLocal;

/**
 * @Author fly.fei
 * @Date 2024/3/8 16:30
 * @Desc
 **/
public final class UserContextHolder {

    private static final ThreadLocal<Context<User>> holder = new NamedThreadLocal<>("UserContextHolder");

    private static final ThreadLocal<Context<User>> inheritableHolder = new NamedInheritableThreadLocal<>("UserContextHolder");

    private UserContextHolder() {
    }

    public static void resetContext() {
        holder.remove();
        inheritableHolder.remove();
    }

    public static void setContext(Context<User> context) {
        setContext(context, false);
    }

    public static void setContext(Context<User> context, boolean inheritable) {
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

    public static Context<User> getContext() {
        Context<User> context = holder.get();
        if (context == null) {
            context = inheritableHolder.get();
        }
        return context;
    }

    public static void setEntity(User entity) {
        setEntity(entity, false);
    }

    public static void setEntity(User entity, boolean inheritable) {
        Context<User> context;
        if (entity != null) {
            context = new SimpleContext<>(entity);
        } else {
            context = null;
        }
        setContext(context, inheritable);
    }

    public static User getEntity() {
        return getEntity(getContext());
    }

    public static User getEntity(Context<User> context) {
        if (context != null) {
            return context.getEntity();
        }
        return null;
    }

}
