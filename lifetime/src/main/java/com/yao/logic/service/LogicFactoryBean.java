package com.yao.logic.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author qingju.yao
 * @date 2020/12/13
 */
@Component
public class LogicFactoryBean implements FactoryBean<LogicFactoryBean.LogicFactoryBeanInner> {

    @Override
    public LogicFactoryBeanInner getObject() throws Exception {
        System.out.println("FactoryBean\tgetObject");
        return new LogicFactoryBeanInner();
    }

    @Override
    public Class<?> getObjectType() {
        return LogicFactoryBeanInner.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


    public static class LogicFactoryBeanInner {
    }
}
