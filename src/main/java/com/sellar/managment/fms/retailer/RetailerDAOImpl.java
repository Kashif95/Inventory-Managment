/**
 * 
 */
package com.sellar.managment.fms.retailer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.agency.domain.AgencyDetail;
import com.sellar.managment.fms.retailer.domain.RetailerDetail;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
public class RetailerDAOImpl implements RetailerDAO{
	
	SessionFactory sessionFactory;

	@Override
	public void saveRetailerDetail(RetailerDetail retailerDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(retailerDetail);
	}

	@Override
	public List<RetailerDetail> getAllRetailerList() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from RetailerDetail");
        return query.list();
	}

	@Override
	public RetailerDetail getRetailerDetailByRetailerId(int retailerId) {
		// TODO Auto-generated method stub
		RetailerDetail retailerDetail = (RetailerDetail) sessionFactory.getCurrentSession().get(RetailerDetail.class, retailerId);
		return retailerDetail;
	}

	@Override
	public void deleteRetailerDetail(RetailerDetail retailerDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(retailerDetail);
	}

	@Override
	public List<RetailerDetail> getSearchedRetailerByFirstName(String searchKey) {
		// TODO Auto-generated method stub
		Query query  = sessionFactory.getCurrentSession().createQuery("from RetailerDetail where retailerFirstName like :firstName");
		query.setString("firstName", "%" +searchKey+"%");
		return query.list();
	}

	@Override
	public List<RetailerDetail> getSearchedRetailerByLastName(String searchKey) {
		// TODO Auto-generated method stub
		Query query  = sessionFactory.getCurrentSession().createQuery("from RetailerDetail where retailerLastName like :lastName");
		query.setString("lastName", "%" +searchKey+"%");
		return query.list();
	}
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired(required=true)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
