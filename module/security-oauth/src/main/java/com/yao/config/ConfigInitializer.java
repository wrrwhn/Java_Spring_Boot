package com.yao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Creator: Yao
 * Date:    2018/10/25
 * For:
 * Other:
 */
@Configuration
public class ConfigInitializer {

    @Bean
    public PasswordEncoder initPWDEncoder() {
        return new BCryptPasswordEncoder();
    }
}
