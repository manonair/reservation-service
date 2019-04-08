package com.mt.discovery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class Oauth2SecurityConfig extends ResourceServerConfigurerAdapter {
 
	private static final String RESOURCE_ID = "resource-server-rest-api";
    
	
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }
	
	
    @Override
	public void configure(HttpSecurity http) throws Exception {
	    http
	    .authorizeRequests()
	    .antMatchers("/user-service/**", "/oauth/**", "/eureka/**", "/login", "/api/user-service/login", "/user/create")
	    .permitAll()
	    .anyRequest()
	    .authenticated()
	    .and()
	    .csrf()
	    .disable();

	}
	
    
	 
	 @Primary
	    @Bean
	    public RemoteTokenServices tokenService() {
	        RemoteTokenServices tokenService = new RemoteTokenServices();
	        tokenService.setCheckTokenEndpointUrl(
	          "http://localhost:2233/oauth/check_token");
	        tokenService.setClientId("oauth2-read-write-client");
	        tokenService.setClientSecret("oauth2-read-write-client-passwordrw123");
	        return tokenService;
	    }

	 
	 
    
}
