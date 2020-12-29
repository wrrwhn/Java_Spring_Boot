package com.yao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author qingju.yao
 * @date 2020/12/13
 */
@Order(2)
@Component
public class CommandLineRunnerImplTwo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner\trun\tCommandLineRunnerImplTwo");

    }
}
