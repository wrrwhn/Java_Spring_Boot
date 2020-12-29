package com.yao.logic;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author qingju.yao
 * @date 2020/12/10
 */
public class LogicApplicationContextInitializer implements ApplicationContextInitializer {
    public LogicApplicationContextInitializer() {
        System.out.println("ApplicationContextInitializer\tConstructor");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer\tinitialize");
    }
}
