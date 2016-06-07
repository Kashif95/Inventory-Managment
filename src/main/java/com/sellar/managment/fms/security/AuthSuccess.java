package com.sellar.managment.fms.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Chris on 10/26/14.
 */
@Component
public class AuthSuccess extends SimpleUrlAuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        /*HttpSession session = request.getSession();
        AccountUserDetails authUser = (AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
        session.setAttribute("uname", authUser.getUserFirstName()); 
        String targetUrl = determineTargetUrl(authentication); 
        redirectStrategy.sendRedirect(request, response, targetUrl);*/
    }
    protected String determineTargetUrl(Authentication authentication) {
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (authorities.contains("Admin")) {
        	return "/home";
        } else {
            throw new IllegalStateException();
        }
    }
	/**
	 * @return the redirectStrategy
	 */
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
	/**
	 * @param redirectStrategy the redirectStrategy to set
	 */
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
    
    
}
