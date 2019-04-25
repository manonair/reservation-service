package com.mt.reservation.config;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableResourceServer
public class ResourceApplication extends ResourceServerConfigurerAdapter {
	
	
	private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/reservation/**";
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }
    
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        
    	http.requestMatchers()
        .antMatchers( "/reservation/**")
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/reservation/**").access("#oauth2.hasScope('read')")
        .antMatchers(HttpMethod.POST, "/reservation/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.POST, SECURED_PATTERN)
        .access(SECURED_WRITE_SCOPE)
        .antMatchers(HttpMethod.GET, SECURED_PATTERN)
        .access(SECURED_READ_SCOPE);

        
       /* http.requestMatchers()
        .antMatchers( "/reservation/**")
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/reservation/**").access("#oauth2.hasScope('read')")
        .antMatchers(HttpMethod.POST, "/reservation/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.POST, SECURED_PATTERN)
        .access(SECURED_WRITE_SCOPE)
        .antMatchers(HttpMethod.GET, SECURED_PATTERN)
        .access(SECURED_READ_SCOPE)
        .and()
        .cors()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .and()
        .csrf()
        .disable();*/
        
    }
    
    /*@Primary
    @Bean
    public RemoteTokenServices tokenServices() {
        final RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl("http://localhost:8082/auth-service/oauth/check_token");
        return tokenService;
    }*/
    
    
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
}
