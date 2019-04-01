package com.mt.user.security.oauth2.config.server;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

	
	 @Bean
	    ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registration = new ServletRegistrationBean( new org.h2.server.web.WebServlet());
	        registration.addUrlMappings("/h2-console/*");
	        registration.addInitParameter("webAllowOthers", "true");
	        registration.addInitParameter("webPort", "7777"); 

	        return registration;
	    }
	 
}
