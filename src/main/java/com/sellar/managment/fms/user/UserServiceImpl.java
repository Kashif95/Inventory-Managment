/**
 * 
 */
package com.sellar.managment.fms.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

	@Override
	public UserDetails getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserId(userId);
	}

	@Override
	public AddressDetail getAddressByAddressId(String addressId) {
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
		}catch(FMSCustomException e){
			throw new FMSCustomException("Error in saving");
		}
		EmailService.SendEmailToUser(user);
		
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


}
