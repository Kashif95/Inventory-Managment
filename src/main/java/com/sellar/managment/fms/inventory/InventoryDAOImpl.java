/**
 * 
 */
package com.sellar.managment.fms.inventory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.inventory.domain.ProductStock;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
public class InventoryDAOImpl implements InventoryDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void saveStockDetails(ProductStock stock) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(stock);
	}

	@Override
	public List<ProductStock> getProductStockList(Short compType) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from ProductStock where companyTypeId = :companyTypeId");
		query.setParameter("companyTypeId", compType);
        return query.list();
		
	}

	@Override
	public List<ProductStock> getSerachedProductListByProductName(String productName,Short compType) {
		// TODO Auto-generated method stub
		Query query  = sessionFactory.getCurrentSession().createQuery("from ProductStock where productDetail.productName like :productName and companyTypeId = :companyTypeId");
		query.setString("productName", "%" +productName+"%");
		query.setParameter("companyTypeId", compType);		return query.list();
	}

	@Override
	public List<ProductStock> getSerachedProductListByAgencyName(
			String agencyName) {
		Query query  = sessionFactory.getCurrentSession().createQuery("from ProductStock where agencyDetail.agencyName like :agencyName");
		query.setString("agencyName", "%" +agencyName+"%");
		return query.list();
	}

	@Override
	public ProductStock getProductStockByStockId(int stockId) {
		// TODO Auto-generated method stub
		return (ProductStock) sessionFactory.getCurrentSession().get(ProductStock.class, stockId);
	}

	@Override
	public void deleteStock(ProductStock stock) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(stock);
	}
	

}
