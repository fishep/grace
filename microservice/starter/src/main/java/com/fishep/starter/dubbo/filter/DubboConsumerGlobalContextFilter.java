package com.fishep.starter.dubbo.filter;

import com.fishep.common.context.GlobalContextHolder;
import org.apache.dubbo.rpc.*;

/**
 * @Author fly.fei
 * @Date 2024/3/4 16:06
 * @Desc
 **/
public class DubboConsumerGlobalContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        System.out.println("DubboConsumerGlobalContextFilter Thread:" + Thread.currentThread().getName());

        RpcContextAttachment attachment = RpcContext.getClientAttachment();
        GlobalContextHolder.load(attachment::setAttachment);

        return invoker.invoke(invocation);
    }

}
