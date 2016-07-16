/**
 * 
 */
package com.sellar.managment.fms.inventory;

import java.util.List;

import com.sellar.managment.fms.inventory.domain.ProductStock;
import com.sellar.managment.fms.inventory.domain.ProductStockMiscDetails;

/**
 * @author rakumari
 *
 */
public interface InventoryDAO {

	void saveStockDetails(ProductStock stock);

	List<ProductStock> getProductStockList(Short compType);

	List<ProductStock> getSerachedProductListByProductName(String productName, Short compType);
	
	List<ProductStock> getSerachedProductListByAgencyName(String agencyName);

	ProductStock getProductStockByStockId(int stockId);

	void deleteStock(ProductStock stock);

	void saveStockMiscDetails(ProductStockMiscDetails misc);

	List<ProductStockMiscDetails> getProductStockMiscDetailsList();

	Integer getTotalStockQuantityByProductId(int productId);

}
