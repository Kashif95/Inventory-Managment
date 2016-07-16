/**
 * 
 */
package com.sellar.managment.fms.util;

import java.util.Random;

/**
 * @author rakumari
 *
 */
public class FPSUtility {
	
	public static final String MEDICAL_ORDER_NUM = "MO";
	public static final String FERTILIZER_ORDER_NUM = "PFO";
	
	
	public static String generateOrderNumber(Integer orderId,Short compType) {
		
		String newOrderNum = null;
		if(orderId==null){
			orderId = 100;
		}
		else{
			orderId = orderId+1;
		}
	
		if(compType==FMSConstant.FERTILIZER_COMP_TYPE){
			newOrderNum = FERTILIZER_ORDER_NUM+orderId.toString();
		}
		else{
			newOrderNum = MEDICAL_ORDER_NUM+orderId.toString();
		}
	   
	return newOrderNum;
	}

}
