/**
 * 
 */
package com.sellar.managment.fms.retailer;

import java.util.List;

import com.sellar.managment.fms.retailer.domain.RetailerDetail;
import com.sellar.managment.fms.retailer.domain.RetailerDetailWrapper;

/**
 * @author rakumari
 *
 */
public interface RetailerService {
	
	void saveRetailerDetail(RetailerDetailWrapper retailDetail, String userName);
	
	List<RetailerDetail> getAllRetailerList();
	
	RetailerDetail getRetailerDetailByRetailerId(String retailerId);

	void deleteRetailerDetail(RetailerDetail retailerDetail);

	List<RetailerDetail> getSearchedRetailer(String searchKey);


}
