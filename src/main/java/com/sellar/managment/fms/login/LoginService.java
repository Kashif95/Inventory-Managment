package com.sellar.managment.fms.login;

import com.sellar.managment.fms.login.domain.LoginDetails;
import com.sellar.managment.fms.user.domain.UserDetails;

public interface LoginService  {
	
	LoginDetails getLoginDetailByMobileNumber(String mobileNum);

	void saveLoginDetails(UserDetails user);

}
