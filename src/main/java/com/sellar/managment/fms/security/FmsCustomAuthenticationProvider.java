/**
 * 
 */
package com.sellar.managment.fms.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/**
 * @author rakumari
 *
 */
@Component
public class FmsCustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailServiceImpl userDetailService;
	
	

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        Short compType = 1;
   
        UserDetails user = userDetailService.loadUserByUsernameAndCompany(username, compType);
   
          if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
              throw new BadCredentialsException("Username not found.");
          }
   
          if (!password.equals(user.getPassword())) {
              throw new BadCredentialsException("Wrong password.");
          }
          
          Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
          
          return new UsernamePasswordAuthenticationToken(user, password, authorities);
          
   
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
