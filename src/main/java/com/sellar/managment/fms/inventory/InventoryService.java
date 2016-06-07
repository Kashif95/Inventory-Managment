/**
 * 
 */
package com.sellar.managment.fms.inventory;

import java.util.List;

import com.sellar.managment.fms.inventory.domain.ProductStock;

/**
 * @author rakumari
 *
 */
public interface InventoryService {

	void saveStockDetails(ProductStock stock, Short compType);

	List<ProductStock> getProductStockList(Short compType);

	List<ProductStock> getSerachedProductList(String productName, Short compType);

	ProductStock getProductStockByStockId(int stockId);

	void deleteStock(ProductStock stock);

	

}
