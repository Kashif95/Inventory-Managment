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
	
	public static final String OrderNumConstant = "MO";
	
	public static String generateOrderId(Integer orderId) {
		if(orderId==null){
			orderId = 100;
		}
		else{
			orderId = orderId+1;
		}
	  String newOrderNum = OrderNumConstant+orderId.toString();
	return newOrderNum;
	}

}
