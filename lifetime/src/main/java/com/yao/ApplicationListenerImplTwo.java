package com.yao;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author qingju.yao
 * @date 2020/12/13
 */
@Component
public class ApplicationListenerImplTwo implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("ApplicationListener\tonApplicationEvent\tApplicationListenerImplTwo");
    }
}
