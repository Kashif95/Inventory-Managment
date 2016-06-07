/**
 * 
 */
package com.sellar.managment.fms.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 * @author rakumari
 *
 */
public class FMSCustomFilter extends AbstractAuthenticationProcessingFilter   {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	public static final String USERNAME_PARAMETER = "username"; 
    private static final String PASSWORD_PARAMETER = "password"; 
    
    private boolean postOnly = true; 
    
    private static final Logger LOGGER = LogManager
            .getLogger(FMSCustomFilter.class);

	  public FMSCustomFilter() {
	    super("/login");
	  }
	  
	  @Override
	  public Authentication attemptAuthentication(HttpServletRequest request,
	    HttpServletResponse response) throws AuthenticationException {
	        
		   String compType = obtainCompanyType(request);
		   Short compTypeShort = null;
		   if(compType!=null)
		   compTypeShort = Short.valueOf(compType);
		   request.getSession().setAttribute("compType", compType);
	        String username = request.getParameter(getUsernameParameter()); 
	        String password =  request.getParameter(getPasswordParameter()); 
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        UsernamePasswordAuthenticationToken authRequest = null;
	        if( authentication!=null){
	        	authentication.setAuthenticated(false);
	        	authentication = null;
	        	//authentication.getCredentials();
	        }
		if (authentication == null) {
			LOGGER.debug("Checking user for company type " + compType);
			UserDetails user = userDetailsService.loadUserByUsernameAndCompany(
					username, compTypeShort);
			LOGGER.debug("User found is " + user);
			if (user != null) {

				if (user == null
						|| !user.getUsername().equalsIgnoreCase(username)) {
					LOGGER.error("Username not found.");
					throw new BadCredentialsException("Username not found.");
				}

				if (!password.equals(user.getPassword())) {
					LOGGER.error("Password not matching");
					throw new BadCredentialsException("Wrong password.");
				}
				Collection<? extends GrantedAuthority> authorities = user
						.getAuthorities();
				authRequest = new UsernamePasswordAuthenticationToken(
						user.getUsername(), user.getPassword(), authorities);
			}
			
		}     
	        
	        setDetails(request, authRequest); 
	        LOGGER.debug("username validated"); 
	        return super.getAuthenticationManager().authenticate(authRequest);
	    } 
	  
	    protected String obtainCompanyType(HttpServletRequest request) { 
	        return request.getParameter("companyType"); 
	    }
	    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) { 
	        authRequest.setDetails(authenticationDetailsSource.buildDetails(request)); 
	    } 
	 
	    /**
	     * Defines whether only HTTP POST requests will be allowed by this filter. If set to true, and an authentication 
	     * request is received which is not a POST request, an exception will be raised immediately and authentication will 
	     * not be attempted. The <tt>unsuccessfulAuthentication()</tt> method will be called as if handling a failed 
	     * authentication. 
	     * <p> 
	     * Defaults to <tt>true</tt> but may be overridden by subclasses. 
	     */ 
	    public void setPostOnly(boolean postOnly) { 
	        this.postOnly = postOnly; 
	    } 
	 
	    public final String getUsernameParameter() { 
	        return USERNAME_PARAMETER; 
	    } 
	 
	    public final String getPasswordParameter() { 
	        return PASSWORD_PARAMETER; 
	    } 
	 

	  @Override
	  public void doFilter(ServletRequest req, ServletResponse res,
	    FilterChain chain) throws IOException, ServletException {
	    final HttpServletRequest request = (HttpServletRequest) req;
	    final HttpServletResponse response = (HttpServletResponse) res;
	    if(request.getMethod().equals("POST")) {
	      // If the incoming request is a POST, then we send it up
	      // to the AbstractAuthenticationProcessingFilter.
	      super.doFilter(request, response, chain);
	    } else {
	      // If it's a GET, we ignore this request and send it
	      // to the next filter in the chain.  In this case, that
	      // pretty much means the request will hit the /login
	      // controller which will process the request to show the
	      // login page.
	      chain.doFilter(request, response);
	    }
	  }
}
