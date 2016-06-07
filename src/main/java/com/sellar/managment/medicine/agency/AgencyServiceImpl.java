/**
 * 
 */
package com.sellar.managment.medicine.agency;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellar.managment.medicine.agency.domain.MedicalAgencyDetail;




/**
 * @author rakumari
 *
 */
@Service(value="medicalAgency")
public class AgencyServiceImpl implements AgencyService {
	
	@Autowired
	private AgencyDAO agencyDao;
	

	@Override
	public List<MedicalAgencyDetail> getAllAgencyList() {
		// TODO Auto-generated method stub
		return agencyDao.getAllAgencyList();
	}

	@Override
	public MedicalAgencyDetail getAgencyDetailByAgencyId(Integer agencyId) {
		// TODO Auto-generated method stub
		MedicalAgencyDetail agencyDetail = agencyDao.getAgencyDetailByAgencyId(agencyId);
		
		return agencyDetail;
	}


	@Override
	public void saveAgencyDetail(MedicalAgencyDetail agencyDetail) {
		// TODO Auto-generated method stub
		if(agencyDetail.getAgencyId()==null){
			agencyDetail.setCreatedOn(new Date());
			agencyDetail.setCreatedBy("Admin");
			agencyDetail.setUpdBy("Admin");
			agencyDetail.setUpdOn(new Date());
		}
		else{
			agencyDetail.setUpdBy("Admin");
			agencyDetail.setUpdOn(new Date());
		}
		//agencyDetail.setAgencyEmail(agencyEmail)(agency.getMobileNumber());
		
		agencyDao.saveAgencyDetail(agencyDetail);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAgencyDetail(MedicalAgencyDetail agencyDetail) {
		// TODO Auto-generated method stub
		agencyDao.deleteAgencyDetail(agencyDetail);
	}


}
