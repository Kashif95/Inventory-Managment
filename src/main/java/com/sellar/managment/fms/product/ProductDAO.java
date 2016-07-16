/**
 * 
 */
package com.sellar.managment.fms.product;

import java.util.List;

import com.sellar.managment.fms.product.domain.ProductDetail;
import com.sellar.managment.fms.product.domain.ProductType;

/**
 * @author rakumari
 *
 */
public interface ProductDAO {
	
	void saveProduct(ProductDetail product);
	
	List<ProductDetail> getAllProductList(Short compType);

	void deleteProduct(ProductDetail productDetail);

	ProductDetail getProductByProductId(int productId);

	List<ProductDetail> getProductListByAgencyId(Integer agencyId, Short compId);

	List<ProductType> getProductTypeList(Short compType);

}
