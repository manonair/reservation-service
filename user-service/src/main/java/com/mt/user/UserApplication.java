package com.mt.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.mt.user.security.oauth2.config.server.SimpleCorsFilter;


@EnableEurekaClient
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	@Bean
	  public SimpleCorsFilter simpleCorsFilter() {
	    return new SimpleCorsFilter();
	  }

}

