package com.fishep.server.dubbo.filter;

import org.apache.dubbo.rpc.*;

import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/3/4 16:06
 * @Desc
 **/
public class DubboProviderContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        //ServerAttachment接收客户端传递过来的参数
        Map<String, Object> serverAttachments = RpcContext.getServerAttachment().getObjectAttachments();
        System.out.println("ContextService serverAttachments:" + serverAttachments);
        //往客户端传递参数
        RpcContext.getServerContext().setAttachment("serverKey", "serverValue_" + System.currentTimeMillis());

        System.out.println("DubboProviderContextFilter invoke before");

        Result result = invoker.invoke(invocation);

        System.out.println("DubboProviderContextFilter invoke after");

        return result;
    }

}
