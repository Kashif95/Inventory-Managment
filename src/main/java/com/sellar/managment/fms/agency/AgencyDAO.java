/**
 * 
 */
package com.sellar.managment.fms.agency;

import java.util.List;

import com.sellar.managment.fms.agency.domain.AgencyDetail;

/**
 * @author rakumari
 *
 */
public interface AgencyDAO {
	
	void saveAgencyDetail(AgencyDetail agencyDetail);
	
	List<AgencyDetail> getAllAgencyList();
	
	AgencyDetail getAgencyDetailByAgencyId(String agencyId);

	void deleteAgencyDetail(AgencyDetail agencyDetail);

}
