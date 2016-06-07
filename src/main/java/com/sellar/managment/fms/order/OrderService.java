/**
 * 
 */
package com.sellar.managment.fms.order;

import java.util.List;
import java.util.Map;

import com.sellar.managment.fms.order.domain.GeneratedOrderDetails;
import com.sellar.managment.fms.order.domain.OrderDetail;
import com.sellar.managment.fms.order.domain.OrderWrapper;
import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;

/**
 * @author rakumari
 *
 */
public interface OrderService {

	void saveOrderDetail(OrderWrapper orderWrapper, Map userMap);

	List<GeneratedOrderDetails> getOrderDetailsList();

	List<OrderedProduct> getOrderedProductList(int orderId);

	OrderDetail getOrderDetailsByOrderId(int orderId);
	
	void saveOrder(OrderDetail orderDetail,String userName);

	void cancelOrderByOrderId(int orderId, Short compType);


}
