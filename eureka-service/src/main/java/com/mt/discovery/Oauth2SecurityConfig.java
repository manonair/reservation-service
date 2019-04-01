package com.mt.discovery;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2SsoDefaultConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2SsoProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
@EnableOAuth2Sso
@EnableGlobalMethodSecurity(prePostEnabled = true, order = 400)
public class Oauth2SecurityConfig extends OAuth2SsoDefaultConfiguration{



	public Oauth2SecurityConfig(ApplicationContext applicationContext, OAuth2SsoProperties sso) {
		super(applicationContext, sso);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable().antMatcher("/**")
		        	.authorizeRequests()
		        .antMatchers(HttpMethod.OPTIONS, "/**")
		        .permitAll()
                .antMatchers("/index.html", "/docs/**", "/oauth/**", "/admin/**", "/ping","/eureka")
                .permitAll()
                .anyRequest()
                .authenticated();

        /*http.addFilterAfter(new ReservationAccessTokenVerificationFilter(200, null, ""),
                SecurityContextPersistenceFilter.class);*/
    }
    
}
