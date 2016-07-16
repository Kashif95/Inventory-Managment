/**
 * 
 */
package com.sellar.managment.fms.product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.product.domain.ProductDetail;
import com.sellar.managment.fms.product.domain.ProductType;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
@Component("agencyProduct")
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveProduct(ProductDetail product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	@Override
	public List<ProductDetail> getAllProductList(Short compType) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from ProductDetail where companyTypeId = :companyTypeId");
		query.setParameter("companyTypeId", compType);
        return query.list();
	}

	@Override
	public void deleteProduct(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(productDetail);
		
	}

	@Override
	public ProductDetail getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		ProductDetail productDetail = (ProductDetail) sessionFactory.getCurrentSession().get(ProductDetail.class, productId);
		return productDetail;
	}

	@Override
	public List<ProductDetail> getProductListByAgencyId(Integer agencyId,Short compType) {
		// TODO Auto-generated method stub
		Query query = null;
		if(compType == 1){
			query  = sessionFactory.getCurrentSession().createQuery("from ProductDetail where agencyId = :agencyId");

		}else{
			query  = sessionFactory.getCurrentSession().createQuery("from ProductDetail where medicineAgencyId = :agencyId");
		}
		query.setParameter("agencyId", agencyId);
		return query.list();
	}

	@Override
	public List<ProductType> getProductTypeList(Short compType) {
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from ProductType WHERE companyTypeId = :companyTypeId ");
		query.setParameter("companyTypeId", compType);
        return query.list();
	}
	/**
	 * @param sessionFactory the sessionFactory to set
	 *//*
	@Autowired(required=true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

}
