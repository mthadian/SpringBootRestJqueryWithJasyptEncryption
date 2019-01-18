package com.KCB.bank;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


/**
 * @author Patrick Muthama
 *
 */
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication
@EnableEncryptableProperties
@EnableJpaRepositories
public class ESBportalApplication {

	public static void main(String[] args) {
		
		//System.out.println("Pista singh is here....");
		SpringApplication.run(ESBportalApplication.class, args);
		
	
	
	}
}
