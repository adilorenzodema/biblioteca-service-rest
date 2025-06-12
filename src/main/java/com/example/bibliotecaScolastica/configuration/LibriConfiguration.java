package com.example.bibliotecaScolastica.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibriConfiguration {
	   @Bean
	    public DataSource dataSource() {
	        return DataSourceBuilder.create()
	                .driverClassName("org.postgresql.Driver")
	                .url("jdbc:postgresql://aws-0-eu-west-2.pooler.supabase.com:5432/postgres")
	                .username("postgres.vstgvcdwlcwlhdqmtwdi")
	                .password("BibliotecaGiugno")
	                .build();
	    }
	}
