/**
 * 
 */
package com.sellar.managment.fms.inventory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sellar.managment.fms.FMSController;
import com.sellar.managment.fms.FMSCustomException;
import com.sellar.managment.fms.inventory.domain.ProductStock;
import com.sellar.managment.fms.util.FMSConstant;

/**
 * @author rakumari
 *
 */
@Controller
public class InventoryController {
	
	private static final Logger LOGGER = LogManager
            .getLogger(InventoryController.class);
	
	@Autowired
	InventoryService inventoryService;
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/stock/saveStock", method= RequestMethod.PUT)
	public String saveStockDetails(@RequestBody String productStock,HttpServletRequest request){
		ObjectMapper mapper = new ObjectMapper();
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		ProductStock stock = null;
		try {
			stock = mapper.readValue(productStock, ProductStock.class);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inventoryService.saveStockDetails(stock,compType);
		
		return "redirect:/stock/getStockList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/stock/getStockList")
	public @ResponseBody List<ProductStock> getProductStockList(HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		return inventoryService.getProductStockList(compType);
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("stock/getProductList")
	public @ResponseBody List<ProductStock> getSerachedProductList(@RequestParam("prodSearchKey") String productSearchKey,HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		
		return inventoryService.getSerachedProductList(productSearchKey,compType);
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/stock/deleteStock")
	public String deleteStock(@RequestBody ProductStock stock ,HttpServletRequest request){
		 try{	
			 inventoryService.deleteStock(stock);
		 }catch(HibernateException e){
				LOGGER.error("database issue while deleting stock data" +e);
				throw new FMSCustomException("database issue while deleting stock data");
			} 
			return "redirect:/stock/getStockList";
	}
	

}
