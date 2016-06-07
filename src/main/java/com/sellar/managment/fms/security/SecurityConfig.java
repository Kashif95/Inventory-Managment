package com.sellar.managment.fms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Rakhi on 1/26/16.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthFailure authFailure;

    @Autowired
    private AuthSuccess authSuccess;

    @Autowired
    private EntryPointUnauthorizedHandler unauthorizedHandler;

    @Autowired
    private UserDetailServiceImpl userDetailService;
    
    /*@Autowired
    private FmsCustomFilter customFilter;*/
    
    @Autowired
    private FmsCustomAuthenticationProvider customAuthenticationProvider;

   @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
    	//PasswordEncoder encoder = new BCryptPasswordEncoder();
        builder.userDetailsService(userDetailService);
    }
    
  /* @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }*/
    
    @Bean 
    public FMSCustomFilter restFilter() throws Exception { 
    	FMSCustomFilter myFilter = new FMSCustomFilter(); 
        myFilter.setAuthenticationManager(authenticationManager()); 
        myFilter.setAuthenticationSuccessHandler(authSuccess); 
        myFilter.setAuthenticationFailureHandler(authFailure); 
    
        return myFilter; 
    } 

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                  .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                .and()
                	.authorizeRequests().antMatchers("/login","/resources/html/login.html","/resources/css/*","/resources/images/*","/resources/js/angular/*","/resources/js/login.js","/resources/js/UiModule.js","/resources/js/googleAnalytics.js","/logout").permitAll()
                	.anyRequest().authenticated()
                 .and()
                    
                 	.formLogin().loginPage("/resources/html/login.html")
                 	.loginProcessingUrl("/login")
                 .and()
                    .addFilterBefore(restFilter(), UsernamePasswordAuthenticationFilter.class);
		        http.logout().logoutUrl("/logout").deleteCookies("JSESSIONID"); 
    }
   
 

   

}
