package com.bujair.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Bujair
 *
 */
@SpringBootApplication
@ComponentScan("com.bujair")
@EnableTransactionManagement
@EnableJpaAuditing
public class MyAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAPIApplication.class, args);
	}
}
