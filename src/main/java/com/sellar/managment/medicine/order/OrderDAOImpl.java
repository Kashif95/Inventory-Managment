/**
 * 
 */
package com.sellar.managment.medicine.order;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.order.domain.OrderDetail;
import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;
import com.sellar.managment.medicine.order.domain.MedicineOrderDetail;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
@Component("medicineOrderDao")
public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void saveOrderDetail(MedicineOrderDetail orderDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);
	}

	@Override
	public void saveOrderdProduct(OrderedProduct product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	@Override
	public List<MedicineOrderDetail> getAllOrderDetails() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from MedicineOrderDetail");
        return query.list();
	}
	
	@Override
	public List<OrderedProduct> getAllOrderdProductByOrderId(int orderId) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from OrderedProduct where medicineOrderId = :orderId");
		query.setParameter("orderId", orderId);
        return query.list();
	}


	@Override
	public MedicineOrderDetail getOrderDetailsByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return (MedicineOrderDetail) sessionFactory.getCurrentSession().get(MedicineOrderDetail.class, orderId);
	}

	@Override
	public Integer getLastOrderId() {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT max(OrderId) maxId from MedicineOrderDetail");
		query.addScalar("maxId", new IntegerType());
		Integer maxOrderId = (Integer) query.uniqueResult();
		return maxOrderId;
	}


}
