/**
 * 
 */
package com.sellar.managment.fms.product;

import java.util.List;
import java.util.Map;

import com.sellar.managment.fms.product.domain.ProductDetail;
import com.sellar.managment.fms.product.domain.ProductDetailWrapper;
import com.sellar.managment.fms.product.domain.ProductType;

/**
 * @author rakumari
 *
 */
public interface ProductService {
	
	void saveProduct(ProductDetailWrapper productDetail, Map userMap);

	List<ProductDetail> getAllProductList(Short compType);

	void deleteProduct(ProductDetail productDetail);

	List<ProductDetail> getProductListByAgencyId(Integer agencyId, Short compType);

	List<ProductType> getProductTypeList(Short compType);

}
