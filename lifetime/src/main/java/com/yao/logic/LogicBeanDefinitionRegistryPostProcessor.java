package com.yao.logic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author qingju.yao
 * @date 2020/12/10
 */
public class LogicBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    public LogicBeanDefinitionRegistryPostProcessor() {
        System.out.println("BeanDefinitionRegistryPostProcessor\tConstructor");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor\tpostProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor\tpostProcessBeanFactory");
    }
}
