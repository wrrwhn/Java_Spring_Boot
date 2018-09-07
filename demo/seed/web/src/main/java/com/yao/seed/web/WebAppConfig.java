package com.yao.seed.web;

import com.yao.seed.web.auth.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authenticationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/**");
    }
}
