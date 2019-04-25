 package com.mt.user.security.oauth2.config.server;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE )
public class SimpleCorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	   /* HttpServletResponse response = (HttpServletResponse) res;
	    HttpServletRequest request = (HttpServletRequest) req;
	    String origin = request.getHeader("Origin");
	    response.setHeader("Access-Control-Allow-Origin", origin);
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Origin, x-requested-with, Authorization, content-type, X-Auth-Token, Access-Control-Allow-Origin");
	    response.setHeader("Access-Control-Allow-Credentials", "true");*/
		 
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) res;
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, origin, authorization, accept, client-security-token");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpResponse.setHeader("Access-Control-Max-Age", "4800");
		System.out.println("---CORS Configuration Completed IN USER SERVICE---");

		if (!request.getMethod().equalsIgnoreCase("OPTIONS")) {
			chain.doFilter(request, httpResponse);
		} else {
			httpResponse.setStatus(HttpServletResponse.SC_OK);
		}
        

//	    chain.doFilter(request, httpResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
