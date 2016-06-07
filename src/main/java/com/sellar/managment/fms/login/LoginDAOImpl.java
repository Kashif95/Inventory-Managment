/**
 * 
 */
package com.sellar.managment.fms.login;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.login.domain.LoginDetails;
import com.sellar.managment.fms.user.domain.UserType;


/**
 * @author rakumari
 *
 */
@Repository
@Transactional
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public LoginDetails getLoginDetailByMobileNumber(String mobileNumber) {
		
		Query query  = sessionFactory.getCurrentSession().createQuery("from LoginDetails where UserId = :mobileNumber");
		query.setParameter("mobileNumber", mobileNumber);
		return 	(LoginDetails) query.uniqueResult();
	}

	@Override
	public void saveLoginDetails(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(loginDetails);
		
	}

	/*@Override
	public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException{
		// TODO Auto-generated method stub
		Query query  = sessionFactory.getCurrentSession().createQuery("from LoginDetails where UserId = :mobileNumber");
		query.setParameter("mobileNumber", mobileNumber);
		LoginDetails login = 	(LoginDetails) query.uniqueResult();
		if(login==null){
			 throw new UsernameNotFoundException("User " + mobileNumber + " could not be found.");
		}else{
			return toUserDetails(login);
		}
	}*/
	/* private UserDetails toUserDetails(LoginDetails userEntity) {
	        UserDetails userDetails = null;

	        if (userEntity != null) {
	            userDetails = new User(userEntity.getUserDetails().getMobileNumber(), 
	            		userEntity.getUserDetails().getPassword(), 
	            		true, true, true, true,getGrantedAuthorities(userEntity.getUserDetails().getUserType()));
	                   
	                    
	        }

	        return userDetails;
	    }*/
	 
	
	 
	
	

}
