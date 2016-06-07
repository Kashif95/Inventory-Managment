/**
 * 
 */
package com.sellar.managment.fms.inventory;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.inventory.domain.ProductStock;
import com.sellar.managment.fms.util.FMSConstant;

/**
 * @author rakumari
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryDAO invDao;

	@Override
	public void saveStockDetails(ProductStock stock,Short compType) {
		// TODO Auto-generated method stub
		if(stock.getProductId()==0){
			stock.setCreatedOn(new Date());
			stock.setCreatedBy("Admin");
			stock.setUpdBy("Admin");
			stock.setUpdOn(new Date());
		}
		else{
			stock.setUpdBy("Admin");
			stock.setUpdOn(new Date());
		}
		stock.setCompanyTypeId(compType);
		invDao.saveStockDetails(stock);
		
	}

	@Override
	public List<ProductStock> getProductStockList(Short compType) {
		// TODO Auto-generated method stub
		return invDao.getProductStockList(compType);
		
	}

	@Override
	public List<ProductStock> getSerachedProductList(String productSerachKey,Short compType) {
		// TODO Auto-generated method stub
		if(null!= productSerachKey){
			
			return invDao.getSerachedProductListByProductName(productSerachKey,compType);
		}
		return null;	
	}

	@Override
	public ProductStock getProductStockByStockId(int stockId) {
		// TODO Auto-generated method stub
		return invDao.getProductStockByStockId(stockId);
	}

	@Override
	public void deleteStock(ProductStock stock) {
		// TODO Auto-generated method stub
		invDao.deleteStock(stock);
	}

}
