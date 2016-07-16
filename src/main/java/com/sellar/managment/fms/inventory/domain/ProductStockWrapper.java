/**
 * 
 */
package com.sellar.managment.fms.inventory.domain;

/**
 * @author rakumari
 *
 */
public class ProductStockWrapper {
	
	private ProductStock productStock;
	private ProductStockMiscDetails miscDetails;
	/**
	 * @return the productStock
	 */
	public ProductStock getProductStock() {
		return productStock;
	}
	/**
	 * @param productStock the productStock to set
	 */
	public void setProductStock(ProductStock productStock) {
		this.productStock = productStock;
	}
	/**
	 * @return the miscDetails
	 */
	public ProductStockMiscDetails getMiscDetails() {
		return miscDetails;
	}
	/**
	 * @param miscDetails the miscDetails to set
	 */
	public void setMiscDetails(ProductStockMiscDetails miscDetails) {
		this.miscDetails = miscDetails;
	}
	
	

}
