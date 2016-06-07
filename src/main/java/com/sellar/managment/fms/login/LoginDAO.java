package com.sellar.managment.fms.login;

import com.sellar.managment.fms.login.domain.LoginDetails;

public interface LoginDAO {
	
	LoginDetails getLoginDetailByMobileNumber(String mobileNum);

	void saveLoginDetails(LoginDetails loginDetails);


}
