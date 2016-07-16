/**
 * 
 */
package com.sellar.managment.fms.product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.product.domain.ProductDetail;
import com.sellar.managment.fms.product.domain.ProductDetailWrapper;
import com.sellar.managment.fms.product.domain.ProductType;
import com.sellar.managment.fms.util.FMSConstant;

/**
 * @author rakumari
 *
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDao;
	
	@Override
	public void saveProduct(ProductDetailWrapper productDetail, Map userDetailMap) {
		
		// TODO Auto-generated method stub
		Short compType = (Short) userDetailMap.get(FMSConstant.USER_COMPANY);
		String userName = (String) userDetailMap.get(FMSConstant.USER_NAME);
		ProductDetail product = null;
		if(productDetail.getProductId()==0){
			 product = new ProductDetail();
			 product.setCreatedBy(userName);
			 product.setCreatedOn(new Date());
			 product.setUpdBy(userName);
			 product.setUpdOn(new Date());
		}
		else{
			product = productDao.getProductByProductId(productDetail.getProductId());
			 product.setUpdBy(userName);
			 product.setUpdOn(new Date());
		}
		if(compType==FMSConstant.FERTILIZER_COMP_TYPE){
			product.setAgencyId(productDetail.getAgencyId());
		}else{
			product.setMedicineAgencyId(productDetail.getAgencyId());
		}
		
		product.setProductName(productDetail.getProductName());
		product.setTypeId(productDetail.getProductTypeId());
		product.setCompanyTypeId(compType);
		productDao.saveProduct(product);
		
		
	}

	@Override
	public List<ProductDetail> getAllProductList(Short compType) {
		// TODO Auto-generated method stub
		return productDao.getAllProductList(compType);
	}

	@Override
	public void deleteProduct(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(productDetail);
		
	}

	@Override
	public List<ProductDetail> getProductListByAgencyId(Integer agencyId,Short compId) {
		// TODO Auto-generated method stub
		if(agencyId!=null){
			return productDao.getProductListByAgencyId(agencyId,compId);
		}
		else{
			return null;
		}
	}

	@Override
	public List<ProductType> getProductTypeList(Short compType) {
		// TODO Auto-generated method stub
		return productDao.getProductTypeList(compType);
	}


}
