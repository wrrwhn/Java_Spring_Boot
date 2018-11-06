package com.yao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Creator: Yao
 * Date:    2018/9/4
 * For:
 * Other:
 */
@SpringBootApplication
@ServletComponentScan("com.yao.filter")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
