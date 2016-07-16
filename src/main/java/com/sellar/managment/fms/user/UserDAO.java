package com.sellar.managment.fms.user;

import java.util.List;

import com.sellar.managment.fms.user.domain.AddressDetail;
import com.sellar.managment.fms.user.domain.UserDetails;
import com.sellar.managment.fms.user.domain.UserType;

public interface UserDAO {

	UserDetails getUserByUserId(String userId);

	AddressDetail getAddressByAddressId(int addressId);

	List<UserType> getAllUserType();

	void saveUserDetails(UserDetails user);

	List<UserDetails> getUserList(Short compType);

	void deleteUser(UserDetails userDetail);

	UserDetails getUserByUserIdAndCompId(String mobileNumber, Short compType);

}
