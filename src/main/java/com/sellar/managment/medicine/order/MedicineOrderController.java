/**
 * 
 */
package com.sellar.managment.medicine.order;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sellar.managment.fms.FMSCustomException;
import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.PaymentService;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;
import com.sellar.managment.fms.util.FMSConstant;
import com.sellar.managment.medicine.order.domain.MedicineOrderDetail;
import com.sellar.managment.medicine.order.domain.MedicineOrderWrapper;

/**
 * @author rakumari
 *
 */
@Controller
public class MedicineOrderController {
	
	@Autowired
	@Qualifier("medicineService")
	OrderService orderService;
	
	@Autowired 
	PaymentService paymentService;
	
	private static final Logger LOGGER = LogManager
            .getLogger(MedicineOrderController.class);
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/medicine/order/saveOrderDetails",method=RequestMethod.PUT)
	public  @ResponseBody String saveOrderDetail(@RequestBody String order,HttpServletRequest request){
		
		ObjectMapper mapper = new ObjectMapper();
		LOGGER.debug("in order controller class");
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		MedicineOrderWrapper orderWrapper = null;
		try{
			
			orderWrapper = mapper.readValue(order,MedicineOrderWrapper.class);
			orderService.saveOrderDetail(orderWrapper,compType);
			
		}catch(Exception e){
			LOGGER.error("Database issue while saving order details in saveOrderDetail" +e);
			throw new FMSCustomException("database issue while saving");
		}
		 return "{\"status\":\"success\"}";
		
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/medicine/order/getOrderDetailsList")
	public @ResponseBody List<MedicineOrderWrapper> getOrderDetailsList(HttpServletRequest request){
		
		return orderService.getOrderDetailsList();
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/medicine/order/getOrderedProductList/{orderId}")
	public @ResponseBody List<OrderedProduct> getOrderedProductList(@PathVariable int orderId){
		
		return orderService.getOrderedProductList(orderId);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/medicine/order/getPaymentDetails/{orderId}")
	public @ResponseBody List<PaymentDetail> getPaymentDetails(@PathVariable int orderId){
		
		return paymentService.getPaymentInfoByOrderId(orderId);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/medicine/order/savePaymentDetails")
	public  String savePaymentDetails(@RequestBody PaymentDetail payment){
		
		try{
			paymentService.saveTransactionDetail(payment);
		}catch(HibernateException e){
			LOGGER.error("database issue while saving payment data" +e);
			throw new FMSCustomException("database issue while saving payment data");
		} 
		return "redirect:/medicine/order/getPaymentDetails/"+payment.getOrderId();
		 
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/medicine/order/getOrderByOrderId/{orderId}")
	public @ResponseBody MedicineOrderDetail getOrderByOrderId(@PathVariable int orderId){
		
		return orderService.getOrderDetailsByOrderId(orderId);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/medicine/order/cancelOrderByOrderId/{orderId}")
	public String  cancelOrderByOrderId(@PathVariable int orderId,HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		 orderService.cancelOrderByOrderId(orderId,compType);
		 return "redirect:/order/getOrderDetailsList";
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/medicine/order/getOrderNumber")
	public @ResponseBody String  getOrderNumber(HttpServletRequest request){
		String orderNum =  orderService.getOrderNumber();
		return "{\"status\":\"success\", \"orderNum\":\"" + orderNum + "\"}";
	}
	
	
	
	
	
	

}
