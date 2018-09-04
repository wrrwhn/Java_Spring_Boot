package com.yao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creator: Yao
 * Date:    2018/9/4
 * For:
 * Other:
 */
@RestController
@EnableAutoConfiguration
public class Application {

    @RequestMapping(value = {"", "/"})
    String home() {
        return "hello spring.boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
