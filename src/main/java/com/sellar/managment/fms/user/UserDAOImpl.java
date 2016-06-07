/**
 * 
 */
package com.sellar.managment.fms.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.user.domain.AddressDetail;
import com.sellar.managment.fms.user.domain.UserDetails;
import com.sellar.managment.fms.user.domain.UserType;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	
    private SessionFactory sessionFactory;

	@Override
	public UserDetails getUserByUserId(String mobileNumber) {

		return  (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class, mobileNumber);
	}

	@Override
	public AddressDetail getAddressByAddressId(String addressId) {
		// TODO Auto-generated method stub
		Query query  = sessionFactory.getCurrentSession().createQuery("from AddressDetail where addressId = :addressId");
		query.setParameter("addressId", addressId);
		return 	(AddressDetail) query.uniqueResult();
	}

	@Override
	public List<UserType> getAllUserType() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from UserType");
        return query.list();
	}

	@Override
	public void saveUserDetails(UserDetails user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public List<UserDetails> getUserList(Short compType) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from UserDetails where userCompTypeId = :userCompTypeId");
		query.setParameter("userCompTypeId", compType);
        return query.list();
	}

	@Override
	public void deleteUser(UserDetails userDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(userDetail);
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired(required=true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserDetails getUserByUserIdAndCompId(String mobileNumber,
			Short compType) {
		// TODO Auto-generated method stub
		Query query  = sessionFactory.getCurrentSession().createQuery("from UserDetails where mobileNumber = :mobileNumber and userCompTypeId = :userCompTypeId");
		query.setParameter("mobileNumber", mobileNumber);
		query.setParameter("userCompTypeId", compType);
		return 	(UserDetails) query.uniqueResult();
	}
	
	

}
