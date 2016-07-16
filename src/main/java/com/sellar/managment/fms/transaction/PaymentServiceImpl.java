/**
 * 
 */
package com.sellar.managment.fms.transaction;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.order.OrderService;
import com.sellar.managment.fms.order.domain.OrderDetail;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;

/**
 * @author rakumari
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentDAO tranDao;
	
	@Autowired
	OrderService orderService;

	@Override
	public void saveTransactionDetail(PaymentDetail payment,String userName) {
		// TODO Auto-generated method stub
		payment.setCreatedBy(userName);
		payment.setUpdBy(userName);
		payment.setCreatedOn(new Date());
		payment.setUpdOn(new Date());
		tranDao.saveTransactionDetail(payment);
		OrderDetail  orderDetail = orderService.getOrderDetailsByOrderId(payment.getOrderId());
		float amountToBePaid = orderDetail.getPendingAmount()-payment.getAmountPaid();
		orderDetail.setPendingAmount(amountToBePaid);
		if(amountToBePaid==0)
			orderDetail.setPaymentStatus(true);
		orderService.saveOrder(orderDetail,userName);
	}

	@Override
	public List<PaymentDetail> getPaymentInfoByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return tranDao.getAllPaymentInfoByOrderId(orderId);
	}

}
