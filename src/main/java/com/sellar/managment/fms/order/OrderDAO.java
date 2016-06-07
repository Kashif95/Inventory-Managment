/**
 * 
 */
package com.sellar.managment.fms.order;

import java.util.List;

import com.sellar.managment.fms.order.domain.OrderDetail;
import com.sellar.managment.fms.order.domain.OrderTransportDetail;
import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;

/**
 * @author rakumari
 *
 */
public interface OrderDAO {

	void saveOrderDetail(OrderDetail orderDetail);

	void saveOrderdProduct(OrderedProduct product);

	List<OrderDetail> getAllOrderDetails();

	List<OrderedProduct> getAllOrderdProductByOrderId(int orderId);

	OrderDetail getOrderDetailsByOrderId(int orderId);

	void saveOrderTransportDetail(OrderTransportDetail transportDetail);



}
