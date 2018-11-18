package com.yao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Creator: Yao
 * Date:    2018/10/18
 * For:
 * Other:
 */
@Configuration
public class SecurityMvcConfig implements WebMvcConfigurer {

    public final static String SESSION_KEY = "USER_SESSION";


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry
                .addInterceptor(new SecurityInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/user/login", "/user/logout",
                        "/redis/**"
                );
    }
}
