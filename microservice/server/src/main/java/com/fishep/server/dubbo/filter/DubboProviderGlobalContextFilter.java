package com.fishep.server.dubbo.filter;

import com.fishep.common.context.GlobalContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.*;

import java.util.Map;

/**
 * @Author fly.fei
 * @Date 2024/3/4 16:06
 * @Desc
 **/
@Slf4j
public class DubboProviderGlobalContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        log.trace("Service: " + invocation.getServiceName() + ", Method: " + invocation.getMethodName());

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
