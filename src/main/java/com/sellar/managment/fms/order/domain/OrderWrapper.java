/**
 * 
 */
package com.sellar.managment.fms.order.domain;

import java.util.List;

import com.sellar.managment.fms.transaction.domain.PaymentDetail;

/**
 * @author rakumari
 *
 */
public class OrderWrapper {
	
	
	private OrderDetail order ;
		
	private List<OrderedProduct> orderedProductList;
	
	private OrderTransportDetail transportDetail;
	
	//private PaymentDetail payment;


	/**
	 * @return the order
	 */
	public OrderDetail getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderDetail order) {
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

	/**
	 * @return the transportDetail
	 */
	public OrderTransportDetail getTransportDetail() {
		return transportDetail;
	}

	/**
	 * @param transportDetail the transportDetail to set
	 */
	public void setTransportDetail(OrderTransportDetail transportDetail) {
		this.transportDetail = transportDetail;
	}
	
	
	

	
	
	
	
	
	

}
