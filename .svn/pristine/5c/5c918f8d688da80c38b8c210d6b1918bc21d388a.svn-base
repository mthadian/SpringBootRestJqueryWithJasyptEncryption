package com.KCB.bank;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Patrick Muthama
 *
 */

@Configuration
@EnableTransactionManagement
@AutoConfigureAfter({DataSourceAutoConfiguration.class }) 

//@EnableConfigurationProperties(value = DataSourceProperties.class)

public class DatabaseConfig 
{
	
       
	@Profile("dev")
	@Bean(name="dev")
	@Primary
	@ConfigurationProperties(prefix="spring.dev.datasource")
	public DataSourceProperties devDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Profile("dev")

	

	@ConfigurationProperties(prefix="spring.dev.datasource")
	public DataSource devDataSource(@Qualifier("dev") DataSourceProperties properties) {
		 return properties.initializeDataSourceBuilder().build();
	}
	
	@Profile("uat")
	@Bean(name="uat")
	@Primary
	@ConfigurationProperties(prefix="spring.uat.datasource")
	public DataSourceProperties uat_dataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Profile("uat")
	
	@ConfigurationProperties(prefix="spring.uat.datasource")
	public DataSource uatDataSource(@Qualifier("uat") DataSourceProperties properties) {
		 return properties.initializeDataSourceBuilder().build();
	}
	
	
	@Profile("sit")
	@Bean(name="sit")
	@Primary
	@ConfigurationProperties(prefix="spring.sit.datasource")
	public DataSourceProperties sitDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Profile("sit")

	@ConfigurationProperties(prefix="spring.sit.datasource")
	public DataSource sitDataSource(@Qualifier("sit") DataSourceProperties properties) {
		 return properties.initializeDataSourceBuilder().build();
	}
	

	
	
}
