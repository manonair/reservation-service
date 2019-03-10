package com.mt.restaurant.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.test.repository", "com.mt.restaurant.repository", "com.mt.restaurant.resource"})
@EnableJpaRepositories( basePackages = {"com.test.repository"})
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	
}

