package com.sellar.managment.fms.login;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.login.domain.LoginDetails;
import com.sellar.managment.fms.user.domain.UserDetails;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDao;
	
	@Override
	public LoginDetails getLoginDetailByMobileNumber(String mobileNum) {
		// TODO Auto-generated method stub
		return loginDao.getLoginDetailByMobileNumber(mobileNum);
	}

	@Override
	public void saveLoginDetails(UserDetails user) {
		// TODO Auto-generated method stub
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setUserDetails(user);
		loginDetails.setCreatedBy("Admin");
		loginDetails.setCreatedOn(new Date());
		loginDetails.setUpdBy("Admin");
		loginDetails.setUpdOn(new Date());
		loginDao.saveLoginDetails(loginDetails);
	}


}
