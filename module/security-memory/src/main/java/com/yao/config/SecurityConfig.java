package com.yao.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Creator: Yao
 * Date:    2018/10/18
 * For:
 * Other:
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ROLE_USER = "USER";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resource/**").permitAll()
                .antMatchers("/user/**").hasAnyRole(ROLE_USER)
                .antMatchers("/h2-console/**").permitAll()
                .and().formLogin();

        // H2 正常连接
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        http.csrf().ignoringAntMatchers("/h2-console/**");
        http.headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // auth.memory
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser(User.withUsername("admin").password(new BCryptPasswordEncoder().encode("admin")).roles(ROLE_USER));
    }
}
