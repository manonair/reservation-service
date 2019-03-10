package com.mt.reservation.config;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
public class ResourceApplication extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
		        .antMatchers( "/reservation/**")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/reservation/**").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST, "/reservation/**").access("#oauth2.hasScope('write')");
    }
    

   

    
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
}