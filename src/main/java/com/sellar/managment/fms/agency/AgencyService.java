package com.sellar.managment.fms.agency;

import java.util.List;

import com.sellar.managment.fms.agency.domain.AgencyDetail;
import com.sellar.managment.fms.agency.domain.AgencyDetailWrapper;
import com.sellar.managment.fms.retailer.domain.RetailerDetailWrapper;

public interface AgencyService {
	
	void saveAgencyDetail(AgencyDetailWrapper agencyDetail, String userName);
	
	List<AgencyDetail> getAllAgencyList();
	
	AgencyDetailWrapper getAgencyDetailByAgencyId(String agencyId);

	void deletAgencyDetail(AgencyDetail agencyDetail);
	
	
	

}
