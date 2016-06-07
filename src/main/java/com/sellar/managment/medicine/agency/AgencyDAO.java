/**
 * 
 */
package com.sellar.managment.medicine.agency;

import java.util.List;

import com.sellar.managment.medicine.agency.domain.MedicalAgencyDetail;




/**
 * @author rakumari
 *
 */
public interface AgencyDAO {
	
	void saveAgencyDetail(MedicalAgencyDetail agencyDetail);
	
	List<MedicalAgencyDetail> getAllAgencyList();
	
	MedicalAgencyDetail getAgencyDetailByAgencyId(Integer agencyId);

	void deleteAgencyDetail(MedicalAgencyDetail agencyDetail);

}
