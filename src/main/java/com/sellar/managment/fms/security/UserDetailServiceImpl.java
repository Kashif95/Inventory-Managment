package com.sellar.managment.fms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sellar.managment.fms.user.UserService;

/**
 * Created by Chris on 10/19/14.
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService service;
    

    @Override
    public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
    	com.sellar.managment.fms.user.domain.UserDetails login = service.getUserByUserId(mobileNumber);
        if(login == null) {
            throw new UsernameNotFoundException("no user found with " + mobileNumber);
        }
        return new AccountUserDetails(login);
    }
    
    public UserDetails loadUserByUsernameAndCompany(String mobileNumber,Short compType) throws UsernameNotFoundException {
    	com.sellar.managment.fms.user.domain.UserDetails login = service.getUserByUserIdAndCompId(mobileNumber,compType);
        if(login == null) {
            throw new UsernameNotFoundException("no user found with " + mobileNumber);
        }
        return new AccountUserDetails(login);
    }
}
