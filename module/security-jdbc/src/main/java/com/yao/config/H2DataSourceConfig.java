package com.yao.config;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Creator: Yao
 * Date:    2018/10/25
 * For:
 * Other:
 */
@Configuration
public class H2DataSourceConfig {

    @Value("${spring.datasource.url:}")
    private String sourceUrl;
    @Value("${spring.datasource.username:}")
    private String sourceUsername;
    @Value("${spring.datasource.password:}")
    private String sourcePassword;

    @Bean
    public DataSource initH2DataSource() {

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(sourceUrl);
        dataSource.setUser(sourceUsername);
        dataSource.setPassword(sourcePassword);
        return dataSource;
    }
}
