package com.fishep.starter.dubbo.filter;

import com.fishep.common.context.GlobalContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.*;

/**
 * @Author fly.fei
 * @Date 2024/3/4 16:06
 * @Desc
 **/
@Slf4j
public class DubboConsumerGlobalContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        log.trace("Service: " + invocation.getServiceName() + ", Method: " + invocation.getMethodName());

        RpcContextAttachment attachment = RpcContext.getClientAttachment();
        GlobalContextHolder.load(attachment::setAttachment);

        return invoker.invoke(invocation);
    }

}
