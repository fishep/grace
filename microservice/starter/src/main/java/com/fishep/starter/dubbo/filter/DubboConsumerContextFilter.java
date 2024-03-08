package com.fishep.starter.dubbo.filter;

import org.apache.dubbo.rpc.*;

/**
 * @Author fly.fei
 * @Date 2024/3/4 16:06
 * @Desc
 **/
public class DubboConsumerContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        //往服务端传递参数
        RpcContext.getClientAttachment().setAttachment("clientKey", "clientValue_" + System.currentTimeMillis());

        Result result = invoker.invoke(invocation);

        //接收传递回来参数
//        Map<String, Object> clientAttachment = RpcContext.getServerContext().getObjectAttachments();
//        System.out.println("ContextTask clientAttachment:" + JSON.toJSONString(clientAttachment));
        System.out.println("ContextTask clientAttachment:" + result.getAttachments());
        System.out.println("ContextService Return : " + result.getValue());

        return result;
    }

}
