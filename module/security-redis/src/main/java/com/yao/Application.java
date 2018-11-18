package com.yao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Creator: Yao
 * Date:    2018/9/28
 * For:
 * Other:
 */
@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 8 * 3600)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
