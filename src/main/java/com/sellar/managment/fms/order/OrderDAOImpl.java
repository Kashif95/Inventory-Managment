/**
 * 
 */
package com.sellar.managment.fms.order;

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
import com.sellar.managment.fms.order.domain.OrderTransportDetail;
import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
@Component("fmsOrder")
public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void saveOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);
	}

	@Override
	public void saveOrderdProduct(OrderedProduct product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	@Override
	public List<OrderDetail> getAllOrderDetails() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from OrderDetail");
        return query.list();
	}
	
	@Override
	public List<OrderedProduct> getAllOrderdProductByOrderId(int orderId) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from OrderedProduct where orderId = :orderId");
		query.setParameter("orderId", orderId);
        return query.list();
	}


	@Override
	public OrderDetail getOrderDetailsByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return (OrderDetail) sessionFactory.getCurrentSession().get(OrderDetail.class, orderId);
	}

	@Override
	public void saveOrderTransportDetail(OrderTransportDetail transportDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(transportDetail);
	}

	@Override
	public Integer getLastOrderId() {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT max(OrderId) maxId from OrderDetail");
		query.addScalar("maxId", new IntegerType());
		Integer maxOrderId = (Integer) query.uniqueResult();
		return maxOrderId;
	}

	@Override
	public OrderTransportDetail getTransportDetailByOrderId(int orderId) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from OrderTransportDetail where orderId = :orderId");
		query.setParameter("orderId", orderId);
		return (OrderTransportDetail) query.uniqueResult();
	}


}
