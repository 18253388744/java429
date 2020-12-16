package com.wdsjol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class JdbcTConfig {
    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
