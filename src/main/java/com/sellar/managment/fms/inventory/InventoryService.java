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
public interface InventoryService {

	void saveStockDetails(ProductStock stock,Short compType, String userName);

	List<ProductStock> getProductStockList(Short compType);

	List<ProductStock> getSerachedProductList(String productName, Short compType);

	ProductStock getProductStockByStockId(int stockId);

	void deleteStock(ProductStock stock);

	void saveStockMiscDetails(ProductStockMiscDetails misc, short compType,
			String userName);

	Integer getTotalStockQuantityByProductId(int productId);

	

}
