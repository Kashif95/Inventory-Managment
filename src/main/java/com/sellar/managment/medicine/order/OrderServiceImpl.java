/**
 * 
 */
package com.sellar.managment.medicine.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.inventory.InventoryService;
import com.sellar.managment.fms.inventory.domain.ProductStock;
import com.sellar.managment.fms.order.domain.GeneratedOrderDetails;
import com.sellar.managment.fms.order.domain.OrderDetail;
import com.sellar.managment.fms.order.domain.OrderWrapper;
import com.sellar.managment.fms.order.domain.OrderedProduct;
import com.sellar.managment.fms.transaction.PaymentService;
import com.sellar.managment.fms.transaction.domain.PaymentDetail;
import com.sellar.managment.fms.util.FMSConstant;
import com.sellar.managment.fms.util.FPSUtility;
import com.sellar.managment.medicine.order.domain.GeneratedMedicalOrderDetails;
import com.sellar.managment.medicine.order.domain.MedicineOrderDetail;
import com.sellar.managment.medicine.order.domain.MedicineOrderWrapper;

/**
 * @author rakumari
 *
 */
@Service(value="medicineService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	@Qualifier("medicineOrderDao")
	OrderDAO orderDao;
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	PaymentService paymentService;

	@Override
	public void saveOrderDetail(MedicineOrderWrapper orderWrapper,Short compType) {
		// TODO Auto-generated method stub
		MedicineOrderDetail orderDetail = orderWrapper.getOrder();
		
		saveOrder(orderDetail);
		
		for(OrderedProduct product : orderWrapper.getOrderedProductList()){
			product.setMedicineOrderId(orderDetail.getOrderId());
			product.setCreatedBy("Admin");
			product.setUpdBy("Admin");
			product.setCreatedOn(new Date());
			product.setUpdOn(new Date());
			orderDao.saveOrderdProduct(product);
			ProductStock prodStock = inventoryService.getProductStockByStockId(product.getStockId());
			float quantity = prodStock.getQuantity()-product.getQuantity();
			prodStock.setQuantity(quantity);
			inventoryService.saveStockDetails(prodStock,compType);
		}
		
		
		
		
	}

	@Override
	public List<MedicineOrderWrapper> getOrderDetailsList() {
		// TODO Auto-generated method stub
		List<MedicineOrderWrapper> generatedOrderList = new ArrayList<>();
		List<MedicineOrderDetail>	orderDetailList = orderDao.getAllOrderDetails();
		for(MedicineOrderDetail order : orderDetailList){
			MedicineOrderWrapper generatedOrder = new MedicineOrderWrapper();
			generatedOrder.setOrder(order);
			generatedOrder.setOrderedProductList(orderDao.getAllOrderdProductByOrderId(order.getOrderId()));
			generatedOrderList.add(generatedOrder);
		}
		return generatedOrderList;
	}

	@Override
	public List<OrderedProduct> getOrderedProductList(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.getAllOrderdProductByOrderId(orderId);
	}

	@Override
	public MedicineOrderDetail getOrderDetailsByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderDetailsByOrderId(orderId);
	}

	@Override
	public void saveOrder(MedicineOrderDetail orderDetail) {
		// TODO Auto-generated method stub
		if(orderDetail.getOrderId()==0){
			
			orderDetail.setCreatedBy("Admin");
			orderDetail.setUpdBy("Admin");
			orderDetail.setCreatedOn(new Date());
			orderDetail.setUpdOn(new Date());
			orderDetail.setOrderStatusTypeId(FMSConstant.ORDERSTATUSTYPE_COMPLETED);
			if(orderDetail.getBalanceAmount()==0){
				orderDetail.setPaymentStatus(true);
			}else{
				orderDetail.setPaymentStatus(false);
			}
			
		}else{
			orderDetail.setUpdBy("Admin");
			orderDetail.setUpdOn(new Date());
		}
		
		orderDao.saveOrderDetail(orderDetail);
	}

	@Override
	public void cancelOrderByOrderId(int orderId,Short compType) {
		// TODO Auto-generated method stub
		
		MedicineOrderDetail order = orderDao.getOrderDetailsByOrderId(orderId);
		List<OrderedProduct> orderedProductList = orderDao.getAllOrderdProductByOrderId(orderId);
		for(OrderedProduct orderedProduct :  orderedProductList){
			float updatedQuan = orderedProduct.getQuantity() + orderedProduct.getProductStock().getQuantity();
			orderedProduct.getProductStock().setQuantity(updatedQuan);
			inventoryService.saveStockDetails(orderedProduct.getProductStock(),compType);
			
		}
		order.setOrderStatusTypeId(FMSConstant.ORDERSTATUSTYPE_CANCELLED);
		orderDao.saveOrderDetail(order);
	}

	@Override
	public String getOrderNumber() {
		// TODO Auto-generated method stub
		Integer orderId = orderDao.getLastOrderId();
		return FPSUtility.generateOrderId(orderId);
	}


}
