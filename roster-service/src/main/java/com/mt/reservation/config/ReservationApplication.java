package com.mt.reservation.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.mt.reservation.model")
@EnableJpaRepositories(basePackages = "com.mt.reservation.repository")
@EnableEurekaClient
public class ReservationApplication   
{

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

	
	 @Bean
	  public SimpleCorsFilter simpleCorsFilter() {
	    return new SimpleCorsFilter();
	  }
}
