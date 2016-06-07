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
public class GeneratedOrderDetails extends OrderWrapper{
	
	private List<PaymentDetail> paymentDetailList;

	/**
	 * @return the paymentDetailList
	 */
	public List<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}

	/**
	 * @param paymentDetailList the paymentDetailList to set
	 */
	
	public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}
	
	

}
