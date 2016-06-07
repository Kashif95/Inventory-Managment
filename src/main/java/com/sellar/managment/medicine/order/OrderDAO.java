/**
 * 
 */
package com.sellar.managment.medicine.order;

import java.util.List;

import com.sellar.managment.fms.order.domain.OrderDetail;
import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;
import com.sellar.managment.medicine.order.domain.MedicineOrderDetail;

/**
 * @author rakumari
 *
 */
public interface OrderDAO {

	void saveOrderDetail(MedicineOrderDetail orderDetail);

	void saveOrderdProduct(OrderedProduct product);

	List<MedicineOrderDetail> getAllOrderDetails();

	List<OrderedProduct> getAllOrderdProductByOrderId(int orderId);

	MedicineOrderDetail getOrderDetailsByOrderId(int orderId);

	Integer getLastOrderId();



}
