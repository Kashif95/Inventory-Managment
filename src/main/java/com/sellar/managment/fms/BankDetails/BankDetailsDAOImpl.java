/**
 * 
 */
package com.sellar.managment.fms.BankDetails;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.BankDetails.domain.BankAccountDetails;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
public class BankDetailsDAOImpl implements BankDetailsDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveBankDetails(BankAccountDetails bankAccountDetails) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(bankAccountDetails);
		
	}

}
