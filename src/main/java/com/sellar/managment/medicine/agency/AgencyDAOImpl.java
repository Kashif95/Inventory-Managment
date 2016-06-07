/**
 * 
 */
package com.sellar.managment.medicine.agency;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sellar.managment.medicine.agency.domain.MedicalAgencyDetail;




/**
 * @author rakumari
 *
 */
@Repository
@Transactional
@Component("medicineagency")
public class AgencyDAOImpl implements AgencyDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<MedicalAgencyDetail> getAllAgencyList() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(
                "from MedicalAgencyDetail");
        return query.list();
	}

	@Override
	public MedicalAgencyDetail getAgencyDetailByAgencyId(Integer agencyId) {
		// TODO Auto-generated method stub
		Query query  = sessionFactory.getCurrentSession().createQuery("from MedicalAgencyDetail where agencyId = :agencyId");
		query.setParameter("agencyId", agencyId);
		return (MedicalAgencyDetail) query.uniqueResult();
	}

	@Override
	public void saveAgencyDetail(MedicalAgencyDetail agencyDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(agencyDetail);
	}

	@Override
	public void deleteAgencyDetail(MedicalAgencyDetail agencyDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(agencyDetail);
	}

}
