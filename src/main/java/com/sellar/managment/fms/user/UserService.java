/**
 * 
 */
package com.sellar.managment.fms.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sellar.managment.fms.user.domain.AddressDetail;
import com.sellar.managment.fms.user.domain.UserDetails;
import com.sellar.managment.fms.user.domain.UserType;

/**
 * @author rakumari
 *
 */
public interface UserService {
	
	UserDetails getUserByUserId(String userId);
	
	AddressDetail getAddressByAddressId(int addressId);

	List<UserType> getAllUserRoleList();
	
	void saveUserDetail(UserDetails user, Map userMap);

	List<UserDetails> getUserList(Short compType);

	void deleteUser(UserDetails userDetail);

	UserDetails getUserByUserIdAndCompId(
			String mobileNumber, Short compType);
	
	String getLoggedInUserName(HttpServletRequest request);
	
	Short getLoggedInUserCompType(HttpServletRequest request);


}
