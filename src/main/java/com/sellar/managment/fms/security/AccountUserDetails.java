package com.sellar.managment.fms.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sellar.managment.fms.user.domain.UserType;

/**
 * Created by Chris on 10/19/14.
 */
public class AccountUserDetails implements UserDetails {
    private final com.sellar.managment.fms.user.domain.UserDetails login;

    public AccountUserDetails(com.sellar.managment.fms.user.domain.UserDetails login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	
    	return getGrantedAuthorities(login.getUserType());
    }
    
    private Collection<GrantedAuthority> getGrantedAuthorities(UserType userType) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        if (userType != null) {
                authorities.add(new SimpleGrantedAuthority(userType.getDescription()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return login.getPassword();
    }

    @Override
    public String getUsername() {
        return login.getMobileNumber();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public String getUserFirstName(){
    	return login.getUserFirstName();
    }
    
    public short getCompanyType(){
    	return login.getUserCompTypeId();
    }
}
