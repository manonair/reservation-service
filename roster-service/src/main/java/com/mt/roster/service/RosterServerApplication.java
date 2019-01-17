package com.mt.roster.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RosterServerApplication   
{

	public static void main(String[] args) {
		SpringApplication.run(RosterServerApplication.class, args);
	}
}
