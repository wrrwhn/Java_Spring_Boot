package com.yao.logic.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * @author qingju.yao
 * @date 2020/12/09
 */
@Service
public class LogicBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    //---------------------------------
    // Field
    //---------------------------------

    private BeanFactory beanFactory;
    private String name;
    private ApplicationContext applicationContext;

    private Date date;

    private String desc;

    //---------------------------------
    // Bean.*
    //---------------------------------

    public LogicBean() {
        System.out.println("Bean\tConstructor");
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        System.out.println("Bean\tsetDate");
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        System.out.println("Bean\tsetDesc");
        this.desc = desc;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Bean\tpostConstruct");
    }

    public void initMethod() {
        System.out.println("Bean\tinitMethod");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Bean\tpreDestroy");
    }

    public void destroyMethod() {
        System.out.println("Bean\tdestroyMethod");
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append(" \"beanFactory\":").append(beanFactory);
        builder.append(", \"name\":\"").append(name).append('\"');
        builder.append(", \"applicationContext\":").append(applicationContext);
        builder.append(", \"date\":\"").append(date).append('\"');
        builder.append(", \"desc\":\"").append(desc).append('\"');
        builder.append('}');
        return builder.toString();
    }

    //---------------------------------
    // Aware.*
    //---------------------------------

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware\tsetBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware\tsetBeanName");
        this.name = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware\tsetApplicationContext");
        this.applicationContext = applicationContext;
    }

    //---------------------------------
    // *Bean.*
    //---------------------------------

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean\tdestroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean\tafterPropertiesSet()");
    }
}
