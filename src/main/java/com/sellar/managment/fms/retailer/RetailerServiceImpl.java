/**
 * 
 */
package com.sellar.managment.fms.retailer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.BankDetails.BankDetailsDAO;
import com.sellar.managment.fms.BankDetails.domain.BankAccountDetails;
import com.sellar.managment.fms.BankDetails.domain.BankAccountWrapper;
import com.sellar.managment.fms.retailer.domain.RetailerDetail;
import com.sellar.managment.fms.retailer.domain.RetailerDetailWrapper;
import com.sellar.managment.fms.user.UserDAO;
import com.sellar.managment.fms.user.domain.AddressDetail;
import com.sellar.managment.fms.util.FMSConstant;

/**
 * @author rakumari
 *
 */
@Service
public class RetailerServiceImpl implements RetailerService{
	
	@Autowired
	private RetailerDAO retailDao;
	
	@Autowired 
	private BankDetailsDAO  bankDetailsDAO;
	
	@Autowired
	private UserDAO userDao;

	@Override
	public void saveRetailerDetail(RetailerDetailWrapper retailer,String userName) {
		
		RetailerDetail retailerDetail = null;
		if(retailer.getRetailerId()==null){
			 retailerDetail = new RetailerDetail();
			 retailerDetail.setCreatedOn(new Date());
			retailerDetail.setCreatedBy(userName);
			retailerDetail.setUpdBy(userName);
			retailerDetail.setUpdOn(new Date());
		}
		else{
			retailerDetail = retailDao.getRetailerDetailByRetailerId(retailer.getRetailerId());
			retailerDetail.setUpdBy(userName);
			retailerDetail.setUpdOn(new Date());
		}
		
		retailerDetail.setRetailerFirstName(retailer.getRetailerFName());
		retailerDetail.setRetailerLastName(retailer.getRetailerLName());
		retailerDetail.setRetailerPanNumber(retailer.getRetailerPanNumber());
		retailerDetail.setAlternateNumber(retailer.getAlternateNumber());
		retailerDetail.setMobileNumber(retailer.getMobileNumber());
		retailerDetail.setUserTypeId(FMSConstant.USERTYPE_RETAILER);
		retailerDetail.setEmail(retailer.getEmail());
		
		AddressDetail addressDetail = null;
		if(retailer.getAddressId()==null){
			 addressDetail = new AddressDetail();
			 addressDetail.setCreatedOn(new Date());
			 addressDetail.setCreatedBy(userName);
			 addressDetail.setUpdBy(userName);
			 addressDetail.setUpdOn(new Date());
				
		}
		else{
			addressDetail = userDao.getAddressByAddressId(retailer.getAddressId());
			addressDetail.setUpdBy(userName);
			addressDetail.setUpdOn(new Date());
		}
		
		addressDetail.setAddressLine1(retailer.getAddressLine1());
		addressDetail.setAddressLine2(retailer.getAddressLine2());
		addressDetail.setCity(retailer.getCity());
		addressDetail.setState(retailer.getState());
		retailerDetail.setAddress(addressDetail);
		retailDao.saveRetailerDetail(retailerDetail);
		if (retailer.getRetailerBankDetails() != null) {
			for (BankAccountWrapper bankaccount : retailer
					.getRetailerBankDetails()) {
				BankAccountDetails bankAccountDetails = new BankAccountDetails();
				bankAccountDetails.setBankAccountNumber(bankaccount
						.getBankAccountNumber());
				bankAccountDetails.setBankName(bankaccount.getBankName());
				bankAccountDetails.setBranchName(bankaccount.getBranchName());
				bankAccountDetails.setIfscCode(bankaccount.getIfscCode());
				bankAccountDetails.setAssociateId(retailerDetail
						.getRetailerId());
				bankDetailsDAO.saveBankDetails(bankAccountDetails);
			}
		}	
		
	}

	@Override
	public List<RetailerDetail> getAllRetailerList() {
		// TODO Auto-generated method stub
		return retailDao.getAllRetailerList();
	}

	@Override
	public RetailerDetail getRetailerDetailByRetailerId(String retailerId) {
		// TODO Auto-generated method stub
		return retailDao.getRetailerDetailByRetailerId(retailerId);
	}

	@Override
	public void deleteRetailerDetail(RetailerDetail retailerDetail) {
		// TODO Auto-generated method stub
		retailDao.deleteRetailerDetail(retailerDetail);
		
	}

	@Override
	public List<RetailerDetail> getSearchedRetailer(String searchKey) {
		// TODO Auto-generated method stub
			
		return retailDao.getSearchedRetailerByFirstName(searchKey);
		
	}

}
