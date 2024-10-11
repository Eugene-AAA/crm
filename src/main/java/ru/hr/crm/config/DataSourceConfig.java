package ru.hr.crm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    @Bean
    public DataSource dataSource() {
        //TODO разобраться, чтобы у каждого всегда вставлялись свои креды автоматически
        return DataSourceBuilder.create()
                .url(URL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();
    }
}
