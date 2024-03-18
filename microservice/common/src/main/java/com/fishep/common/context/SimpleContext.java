package com.fishep.common.context;

/**
 * @Author fly.fei
 * @Date 2024/3/8 17:20
 * @Desc
 **/
public class SimpleContext<T> implements Context<T> {

    private final T t;

    public SimpleContext(T t) {
        this.t = t;
    }

    @Override
    public T getEntity() {
        return t;
    }

}
