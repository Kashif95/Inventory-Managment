/**
 * 
 */
package com.sellar.managment.medicine.order.domain;

import java.util.List;

import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;

/**
 * @author rakumari
 *
 */
public class MedicineOrderWrapper {
	
	
	private MedicineOrderDetail order ;
		
	private List<OrderedProduct> orderedProductList;
	
	//private PaymentDetail payment;


	/**
	 * @return the order
	 */
	public MedicineOrderDetail getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(MedicineOrderDetail order) {
		this.order = order;
	}

	/**
	 * @return the orderedProductList
	 */
	public List<OrderedProduct> getOrderedProductList() {
		return orderedProductList;
	}

	/**
	 * @param orderedProductList the orderedProductList to set
	 */
	public void setOrderedProductList(List<OrderedProduct> orderedProductList) {
		this.orderedProductList = orderedProductList;
	}

	
	
	
	
	
	

}
