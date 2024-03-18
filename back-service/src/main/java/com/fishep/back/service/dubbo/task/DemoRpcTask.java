package com.fishep.back.service.dubbo.task;

import com.fishep.sso.common.interfaces.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;

/**
 * @Author fly.fei
 * @Date 2024/3/1 14:34
 * @Desc
 **/
//@Component
//@ConditionalOnProperty(value = "dubbo.protocol.name", havingValue = "dubbo")
public class DemoRpcTask implements CommandLineRunner {

    @DubboReference
    private DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        String result = demoService.sayHello("world");
        System.out.println("Receive result ======> " + result);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + " Receive result ======> " + demoService.sayHello("world"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

}
