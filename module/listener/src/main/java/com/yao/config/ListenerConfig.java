package com.yao.config;

import com.yao.listener.ORRequestListener;
import com.yao.listener.ORServletContextListener;
import com.yao.listener.ORSessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Creator: Yao
 * Date:    2018/11/6
 * For:
 * Other:
 */
@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean<ORServletContextListener> initServletContextListener() {

        ServletListenerRegistrationBean<ORServletContextListener> registration = new ServletListenerRegistrationBean<ORServletContextListener>();
        registration.setListener(new ORServletContextListener());
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ORSessionListener> initSessionListener() {

        ServletListenerRegistrationBean<ORSessionListener> registration = new ServletListenerRegistrationBean<ORSessionListener>();
        registration.setListener(new ORSessionListener());
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ORRequestListener> initRequestListener() {

        ServletListenerRegistrationBean<ORRequestListener> registration = new ServletListenerRegistrationBean<ORRequestListener>();
        registration.setListener(new ORRequestListener());
        return registration;
    }
}
