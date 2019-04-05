package com.mt.discovery;




public class ReservationAccessTokenVerificationFilter /*extends OncePerRequestFilter*/ {


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

 


