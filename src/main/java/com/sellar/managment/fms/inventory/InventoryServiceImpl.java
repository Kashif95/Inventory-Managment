/**
 * 
 */
package com.sellar.managment.fms.inventory;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.FMSCustomException;
import com.sellar.managment.fms.inventory.domain.ProductStock;
import com.sellar.managment.fms.inventory.domain.ProductStockMiscDetails;

/**
 * @author rakumari
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryDAO invDao;

	@Override
	public void saveStockDetails(ProductStock stock,Short compType,String userName) {
		// TODO Auto-generated method stub
		if(stock.getProductStockId()==0){
			stock.setCreatedOn(new Date());
			stock.setCreatedBy(userName);
			stock.setUpdBy(userName);
			stock.setUpdOn(new Date());
		}
		else{
			stock.setUpdBy(userName);
			stock.setUpdOn(new Date());
		}
		stock.setCompanyTypeId(compType);
		try{
			invDao.saveStockDetails(stock);
		}catch(DataAccessException e){
			throw new FMSCustomException("Not able to save data for product stock"+e.getMessage());
		}
		
		
	}

	@Override
	public List<ProductStock> getProductStockList(Short compType) {
		return invDao.getProductStockList(compType);
		
	}

	@Override
	public List<ProductStock> getSerachedProductList(String productSerachKey,Short compType) {
		if(null!= productSerachKey){
			
			return invDao.getSerachedProductListByProductName(productSerachKey,compType);
		}
		return null;	
	}

	@Override
	public ProductStock getProductStockByStockId(int stockId) {
		return invDao.getProductStockByStockId(stockId);
	}

	@Override
	public void deleteStock(ProductStock stock) {
		invDao.deleteStock(stock);
	}

	@Override
	public void saveStockMiscDetails(ProductStockMiscDetails misc,
			short compType, String userName) {
			misc.setUpdBy(userName);
			misc.setUpdOn(new Date());
		try{
			invDao.saveStockMiscDetails(misc);
		}
		catch(DataAccessException e){
			throw new FMSCustomException("Not able to save data for product stock"+e.getMessage());
		}
		
	}

	@Override
	public Integer getTotalStockQuantityByProductId(int productId) {
		
		return invDao.getTotalStockQuantityByProductId(productId);
		
	}

}
