/**
 * 
 */
package com.sellar.managment.fms.transaction;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.transaction.domain.PaymentDetail;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
public class PaymentDAOImpl implements PaymentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveTransactionDetail(PaymentDetail payment) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(payment);
	}

	@Override
	public List<PaymentDetail> getAllPaymentInfoByOrderId(int orderId) {
		
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from PaymentDetail where orderId = :orderId");
		query.setParameter("orderId", orderId);
        return query.list();
		
	}

}
