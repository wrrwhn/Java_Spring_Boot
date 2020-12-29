package com.yao.logic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author qingju.yao
 * @date 2020/12/09
 */
public class LogicBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public LogicBeanFactoryPostProcessor() {
        System.out.println("BeanFactoryPostProcessor\tConstructor");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final BeanDefinition definition = beanFactory.getBeanDefinition("logicBean");
        System.out.println("BeanFactoryPostProcessor\tpostProcessBeanFactory->  LogicBean.setDate");
        definition.getPropertyValues().addPropertyValue("date", new Date());
    }
}
