package com.mt.discovery;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@EnableZuulProxy
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryMicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryMicroserviceServerApplication.class, args);
	}


    @Bean
    RequestDumperFilter requestDumperFilter() {
    	return new RequestDumperFilter();
    }
    
}
