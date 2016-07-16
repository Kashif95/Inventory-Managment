/**
 * 
 */
package com.sellar.managment.fms.order;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sellar.managment.fms.FMSCustomException;
import com.sellar.managment.fms.order.domain.GeneratedOrderDetails;
import com.sellar.managment.fms.order.domain.OrderDetail;
import com.sellar.managment.fms.order.domain.OrderWrapper;
import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.PaymentService;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;
import com.sellar.managment.fms.util.FMSConstant;

/**
 * @author rakumari
 *
 */
@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired 
	PaymentService paymentService;
	
	private static final Logger LOGGER = LogManager
            .getLogger(OrderController.class);
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/order/saveOrderDetails",method=RequestMethod.PUT)
	public  @ResponseBody String saveOrderDetail(@RequestBody String order,HttpServletRequest request){
		
		ObjectMapper mapper = new ObjectMapper();
		LOGGER.debug("in order controller class");
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		//Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		OrderWrapper orderWrapper = null;
		try{
			
			orderWrapper = mapper.readValue(order,OrderWrapper.class);
			orderService.saveOrderDetail(orderWrapper,userMap);
			
		}catch(Exception e){
			LOGGER.error("Database issue while saving order details in saveOrderDetail" +e);
			throw new FMSCustomException("database issue while saving");
		}
		 return "{\"status\":\"success\"}";
		
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/order/getOrderDetailsList")
	public @ResponseBody List<GeneratedOrderDetails> getOrderDetailsList(){
		
		return orderService.getOrderDetailsList();
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/order/getOrderedProductList/{orderId}")
	public @ResponseBody List<OrderedProduct> getOrderedProductList(@PathVariable int orderId){
		
		return orderService.getOrderedProductList(orderId);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/order/getPaymentDetails/{orderId}")
	public @ResponseBody List<PaymentDetail> getPaymentDetails(@PathVariable int orderId){
		
		return paymentService.getPaymentInfoByOrderId(orderId);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/order/savePaymentDetails")
	public  String savePaymentDetails(@RequestBody PaymentDetail payment,HttpServletRequest request){
		
		try{
			Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
			String userName = (String) userMap.get(FMSConstant.USER_NAME);
			paymentService.saveTransactionDetail(payment,userName);
		}catch(HibernateException e){
			LOGGER.error("database issue while saving payment data" +e);
			throw new FMSCustomException("database issue while saving payment data");
		} 
		return "redirect:/order/getPaymentDetails/"+payment.getOrderId();
		 
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/order/getOrderByOrderId/{orderId}")
	public @ResponseBody OrderDetail getOrderByOrderId(@PathVariable int orderId){
		
		return orderService.getOrderDetailsByOrderId(orderId);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/order/cancelOrderByOrderId/{orderId}")
	public String  cancelOrderByOrderId(@PathVariable int orderId,HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		 orderService.cancelOrderByOrderId(orderId,userMap);
		 return "redirect:/order/getOrderDetailsList";
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/order/getOrderNumber")
	public @ResponseBody String  getOrderNumber(HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		String orderNum =  orderService.getOrderNumber(compType);
		return "{\"status\":\"success\", \"orderNum\":\"" + orderNum + "\"}";
	}
	
	
	
	

}
