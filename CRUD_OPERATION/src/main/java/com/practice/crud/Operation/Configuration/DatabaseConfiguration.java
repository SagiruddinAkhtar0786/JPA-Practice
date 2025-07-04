package com.practice.crud.Operation.Configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {
	
	@Bean
	public DataSource getDataSource() {
		
		HikariDataSource datasource = new HikariDataSource();
		
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/TestConnection");
		datasource.setUsername("root");
		datasource.setPassword("123456");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return datasource;
	}

}
