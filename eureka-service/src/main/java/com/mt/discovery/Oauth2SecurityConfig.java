package com.mt.discovery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
@EnableWebSecurity
public class Oauth2SecurityConfig extends ResourceServerConfigurerAdapter {
 
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/secured/**";
    
    
	private static final String RESOURCE_ID = "resource-server-rest-api";
    /*@Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }*/
	
	
    @Override
	public void configure(HttpSecurity http) throws Exception {
	    http
	    .authorizeRequests()
	    .antMatchers("/user-service/**", "/oauth/**", "/eureka/**", "/login", "/api/user-service/login")
	    .permitAll()
	    .anyRequest()
	    .authenticated()
	    .and()
	    .csrf().disable();

	}
	
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:2233/oauth/check_token");
        remoteTokenServices.setClientId("oauth2-read-write-client");
        remoteTokenServices.setClientSecret("oauth2-read-write-client-passwordrw123");
        resources.tokenServices(remoteTokenServices);
        resources.resourceId(RESOURCE_ID);
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

	 
	 

	/**/

	/*@Override
    public void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable().antMatcher("/**")
		        	.authorizeRequests()
		        .antMatchers(HttpMethod.OPTIONS, "/**")
		        .permitAll()
                .antMatchers("/index.html", "/docs/**", "/oauth/**", "/admin/**", "/ping","/eureka")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.addFilterAfter(new ReservationAccessTokenVerificationFilter(200, null, ""),
                SecurityContextPersistenceFilter.class);
    }*/
    
}
