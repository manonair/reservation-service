package com.mt.user.security.oauth2.config.server;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@EnableEurekaClient
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/secured/**";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .requestMatchers()
		        .antMatchers(SECURED_PATTERN, "/oauth/**", "/eureka/**", "/login/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**", "/secured/**").permitAll()
                .antMatchers("/login/**").permitAll()
                /*.antMatchers(HttpMethod.POST, SECURED_PATTERN)
                .access(SECURED_WRITE_SCOPE)
                .antMatchers(HttpMethod.GET, SECURED_PATTERN)
                .access(SECURED_READ_SCOPE)
                .anyRequest()
                .authenticated()*/;
    }
    
    
    
    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails resource){
        return new OAuth2RestTemplate(resource);
    }
}
