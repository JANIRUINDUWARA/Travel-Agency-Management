package com.travelAgent.booking_service.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/travel_management_db")
                .username("travelapp")
                .password("strong_password")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
