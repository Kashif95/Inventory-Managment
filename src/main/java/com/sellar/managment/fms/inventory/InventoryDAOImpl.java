/**
 * 
 */
package com.sellar.managment.fms.inventory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.inventory.domain.ProductStock;
import com.sellar.managment.fms.inventory.domain.ProductStockMiscDetails;

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
		sessionFactory.getCurrentSession().delete(stock.getStockMiscDetail());
		sessionFactory.getCurrentSession().delete(stock);
	}

	@Override
	public void saveStockMiscDetails(ProductStockMiscDetails misc) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(misc);
	}

	@Override
	public List<ProductStockMiscDetails> getProductStockMiscDetailsList() {
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from ProductStockMiscDetails");
        return query.list();
	}

	@Override
	public Integer getTotalStockQuantityByProductId(int productId) {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT SUM(Quantity) AS TotalQunat FROM ProductStock WHERE ProductId ="+productId;
		Integer qunatity = (Integer) sessionFactory.getCurrentSession().createSQLQuery(sqlQuery).
		addScalar("TotalQunat", new IntegerType())
		.uniqueResult();
		return qunatity;
	}
	

}
