/**
 * 
 */
package com.sellar.managment.fms.agency;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.fms.agency.domain.AgencyDetail;

/**
 * @author rakumari
 *
 */
@Repository
@Transactional
@Component("fmsagency")
public class AgencyDAOImpl implements AgencyDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void saveAgencyDetail(AgencyDetail agencyDetail) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().saveOrUpdate(agencyDetail);
		
	}

	@Override
	public List<AgencyDetail> getAllAgencyList() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from AgencyDetail");
        return query.list();
	}

	@Override
	public AgencyDetail getAgencyDetailByAgencyId(Integer agencyId) {
		// TODO Auto-generated method stub
		Query query  = sessionFactory.getCurrentSession().createQuery("from AgencyDetail where agencyId = :agencyId");
		query.setParameter("agencyId", agencyId);
		return (AgencyDetail) query.uniqueResult();
	}

	@Override
	public void deleteAgencyDetail(AgencyDetail agencyDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(agencyDetail);
	}

	
	

	
	

}
