package com.yao;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author qingju.yao
 * @date 2020/12/13
 */
@Order(1)
@Component
public class ApplicationRunnerImplOne implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner\trun\tApplicationRunnerImplOne");
    }
}
