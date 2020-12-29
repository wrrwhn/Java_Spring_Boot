package com.yao.logic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author qingju.yao
 * @date 2020/12/09
 */
public class LogicBeanPostProcessor implements BeanPostProcessor {

    public LogicBeanPostProcessor() {
        System.out.println("BeanPostProcessor\tConstructor");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor\tpostProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor\tpostProcessAfterInitialization");
        return bean;
    }
}
