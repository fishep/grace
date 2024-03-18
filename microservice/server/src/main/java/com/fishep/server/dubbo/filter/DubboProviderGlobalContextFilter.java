package com.fishep.server.dubbo.filter;

import com.fishep.common.context.GlobalContextHolder;
import org.apache.dubbo.rpc.*;

import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/3/4 16:06
 * @Desc
 **/
public class DubboProviderGlobalContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        System.out.println("DubboProviderGlobalContextFilter Thread:" + Thread.currentThread().getName());

        Map<String, Object> attachments = RpcContext.getServerAttachment().getObjectAttachments();
        GlobalContextHolder.unload(k -> (String) attachments.get(k));

        try {
            return invoker.invoke(invocation);
        } catch (Exception e) {
            throw e;
        } finally {
            GlobalContextHolder.resetContext();
        }

    }

}
