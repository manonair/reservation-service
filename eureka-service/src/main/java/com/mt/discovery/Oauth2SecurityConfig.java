package com.mt.discovery;

import java.util.Arrays;

import javax.ws.rs.container.ContainerResponseFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableResourceServer
public class Oauth2SecurityConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource-server-rest-api";

	@Value("${application.oauth.token.check.uri}")
	private String OauthTokenCheckUri;

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
	    ;

		
	}

	
	/**
	 * Check token for the incoming request
	 * @return
	 */
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
		RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl("http://localhost:2233/oauth/check_token");
		tokenService.setClientId("oauth2-read-write-client");
		tokenService.setClientSecret("oauth2-read-write-client-passwordrw123");
		return tokenService;
	}

}
