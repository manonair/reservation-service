package com.mt.discovery;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;




public class ReservationAccessTokenVerificationFilter /*extends OncePerRequestFilter*/ {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationAccessTokenVerificationFilter.class);

	/*@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String header = request.getHeader("Authorization");
		
		
		// 2. validate the header and check the prefix
				if(header == null || !header.startsWith(jwtConfig.getPrefix())) {
					filterChain.doFilter(request, response);  		// If not valid, go to the next filter.
					return;
				}

		
	}*/

    /*public ReservationAccessTokenVerificationFilter(long tokenVerificationInterval, String unauthorizedUrl,
            String checkTokenEndpointURL) {
        super(tokenVerificationInterval, unauthorizedUrl, checkTokenEndpointURL);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        String redirectUrl = httpReq.getRequestURI();
        String query = httpReq.getQueryString();

        if (StringUtils.isNotBlank(query)) {
            redirectUrl += "?" + query;
        }

        LOGGER.info("Redirect Url for verification: {}", redirectUrl);
        setRedirectUrl(redirectUrl);

        super.doFilter(request, response, chain);
    }*/
}

 
class OauthConfig {
    @Value("${security.oauth2.resource.token-info-uri:/auth/**}")
    private String Uri;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration;

    @Value("${security.jwt.secret:JwtSecretKey}")
    private String secret;
	
    // getters ...
}

