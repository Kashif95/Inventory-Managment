/**
 * 
 */
package com.seller.managment.fms.order;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sellar.managment.fms.order.OrderService;

/**
 * @author rakumari
 *
 */
public class OrderServiceTestIntg {

	@Autowired
	OrderService orderService;
	@Test
	public void testGetOrderNumber() {
		
		Short compType = 1;
		String ordrrNum = orderService.getOrderNumber(compType);
		System.out.println(ordrrNum);
	}

}
