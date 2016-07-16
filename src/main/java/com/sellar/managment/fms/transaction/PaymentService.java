/**
 * 
 */
package com.sellar.managment.fms.transaction;

import java.util.List;

import com.sellar.managment.fms.transaction.domain.PaymentDetail;


/**
 * @author rakumari
 *
 */
public interface PaymentService {

	void saveTransactionDetail(PaymentDetail payment,String userName);

	List<PaymentDetail> getPaymentInfoByOrderId(int orderId);

}
