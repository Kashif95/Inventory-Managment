/**
 * 
 */
package com.sellar.managment.fms.agency;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.agency.domain.AgencyDetail;
import com.sellar.managment.fms.agency.domain.AgencyDetailWrapper;
import com.sellar.managment.fms.retailer.domain.RetailerDetailWrapper;
import com.sellar.managment.fms.user.UserDAO;
import com.sellar.managment.fms.user.domain.AddressDetail;

/**
 * @author rakumari
 *
 */
@Service(value="fmsAgency")
public class AgencyServiceImpl implements AgencyService {
	
	@Autowired
	private AgencyDAO agencyDao;
	
	@Autowired
	private UserDAO userDao;

	@Override
	public void saveAgencyDetail(AgencyDetailWrapper agency,String userName) {
		
		AgencyDetail agencyDetail = null;
		if(agency.getAgencyId()==null){
			agencyDetail = new AgencyDetail();
			agencyDetail.setCreatedOn(new Date());
			agencyDetail.setCreatedBy(userName);
			agencyDetail.setUpdBy(userName);
			agencyDetail.setUpdOn(new Date());
		}
		else{
			agencyDetail = agencyDao.getAgencyDetailByAgencyId(agency.getAgencyId());
			agencyDetail.setUpdBy(userName);
			agencyDetail.setUpdOn(new Date());
		}
		agencyDetail.setAgencyName(agency.getAgencyName());
		agencyDetail.setAgencySupervisor(agency.getAgencySupervisor());
		agencyDetail.setOwnerName(agency.getOwnerName());
		agencyDetail.setAlternateNumber(agency.getAlternateNumber());
		agencyDetail.setMobileNumber(agency.getMobileNumber());
		agencyDetail.setEmail(agency.getEmail());
		
		
		AddressDetail addressDetail = null;
		if(agency.getAddressId()==null){
			
			 addressDetail = new AddressDetail();
		}
		else{
			addressDetail = userDao.getAddressByAddressId(agency.getAddressId());
		}
		
		addressDetail.setAddressLine1(agency.getAddressLine1());
		addressDetail.setAddressLine2(agency.getAddressLine2());
		addressDetail.setCity(agency.getCity());
		addressDetail.setState(agency.getState());
		addressDetail.setCreatedOn(new Date());
		addressDetail.setCreatedBy(userName);
		addressDetail.setUpdBy(userName);
		addressDetail.setUpdOn(new Date());
		agencyDetail.setAddress(addressDetail);
		
		agencyDao.saveAgencyDetail(agencyDetail);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AgencyDetail> getAllAgencyList() {
		// TODO Auto-generated method stub
		return agencyDao.getAllAgencyList();
	}

	@Override
	public AgencyDetailWrapper getAgencyDetailByAgencyId(String agencyId) {
		// TODO Auto-generated method stub
		AgencyDetail agencyDetail = agencyDao.getAgencyDetailByAgencyId(agencyId);
		AgencyDetailWrapper agency = new AgencyDetailWrapper();
		agency.setAgencyName(agencyDetail.getAgencyName());
		agency.setAgencySupervisor(agencyDetail.getAgencySupervisor());
		agency.setAddressLine1(agencyDetail.getAddress().getAddressLine1());
		agency.setAddressLine2(agencyDetail.getAddress().getAddressLine2());
		agency.setCity(agencyDetail.getAddress().getCity());
		agency.setState(agencyDetail.getAddress().getState());
		agency.setOwnerName(agencyDetail.getOwnerName());
		
		return agency;
	}

	@Override
	public void deletAgencyDetail(AgencyDetail agencyDetail) {
		// TODO Auto-generated method stub
		agencyDao.deleteAgencyDetail(agencyDetail);
	}


}
