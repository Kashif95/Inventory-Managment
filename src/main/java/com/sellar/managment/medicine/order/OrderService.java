/**
 * 
 */
package com.sellar.managment.medicine.order;

import java.util.List;
import java.util.Map;

import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.medicine.order.domain.MedicineOrderDetail;
import com.sellar.managment.medicine.order.domain.MedicineOrderWrapper;

/**
 * @author rakumari
 *
 */
public interface OrderService {

	void saveOrderDetail(MedicineOrderWrapper orderWrapper, Map userMap);

	List<MedicineOrderWrapper> getOrderDetailsList();

	List<OrderedProduct> getOrderedProductList(int orderId);

	MedicineOrderDetail getOrderDetailsByOrderId(int orderId);
	
	void saveOrder(MedicineOrderDetail orderDetail);

	void cancelOrderByOrderId(int orderId, Short compType);

	String getOrderNumber(Short compType);


}
