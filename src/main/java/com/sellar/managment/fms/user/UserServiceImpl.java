/**
 * 
 */
package com.sellar.managment.fms.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.FMSCustomException;
import com.sellar.managment.fms.user.domain.AddressDetail;
import com.sellar.managment.fms.user.domain.UserDetails;
import com.sellar.managment.fms.user.domain.UserType;
import com.sellar.managment.fms.util.EmailService;
import com.sellar.managment.fms.util.FMSConstant;

/**
 * @author rakumari
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	EmailService emailService;

	@Override
	public UserDetails getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserId(userId);
	}

	@Override
	public AddressDetail getAddressByAddressId(int addressId) {
		// TODO Auto-generated method stub
		return userDao.getAddressByAddressId(addressId);
	}

	@Override
	public List<UserType> getAllUserRoleList() {
		// TODO Auto-generated method stub
		return userDao.getAllUserType();
	}

	@Override
	public void saveUserDetail(UserDetails user,Map userDetailMap) {
		// TODO Auto-generated method stub
		Short compType = (Short) userDetailMap.get(FMSConstant.USER_COMPANY);
		String userName = (String) userDetailMap.get(FMSConstant.USER_NAME);
		user.setUserCompTypeId(compType);
		user.setCreatedBy(userName);
		user.setCreatedOn(new Date());
		try{
			userDao.saveUserDetails(user);
			emailService.SendEmail("Account Creation Notification",getEmailMessage(user),user.getUserEmail());
			
			
		}catch(FMSCustomException e){
			throw new FMSCustomException("Error in saving user data");
		}
		
		
	}

	@Override
	public List<UserDetails> getUserList(Short compType) {
		// TODO Auto-generated method stub
		return userDao.getUserList(compType);
	}

	@Override
	public void deleteUser(UserDetails userDetail) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userDetail);
	}

	@Override
	public UserDetails getUserByUserIdAndCompId(String mobileNumber,
			Short compType) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserIdAndCompId(mobileNumber,compType);
	}

	@Override
	public String getLoggedInUserName(HttpServletRequest request) {
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		return (String) userMap.get(FMSConstant.USER_NAME);
	}

	@Override
	public Short getLoggedInUserCompType(HttpServletRequest request) {
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		return compType;
	}
	
	public String getEmailMessage(UserDetails user){
		String emailMessage  = 
		"Dear " +  user.getUserFirstName() +","
				+ "\n\n Your account has been created on Prasad Fertilizer. Your username is " + user.getMobileNumber() +" and password is " + user.getPassword()+ "."+
				"Please click on this url http://pf-rakhitest.rhcloud.com/inventory/login to login."	
				+"\n\n Regards,"
				+"\n\n Admin"
				+"\n Prasad Fertilzer";
		
		return emailMessage;
				
		
	}


}
