/**
 * 
 */
package com.sellar.managment.fms.retailer;

import java.util.List;

import com.sellar.managment.fms.retailer.domain.RetailerDetail;

/**
 * @author rakumari
 *
 */
public interface RetailerDAO {
	
	void saveRetailerDetail(RetailerDetail retailerDetail);
	
	List<RetailerDetail> getAllRetailerList();
	
	RetailerDetail getRetailerDetailByRetailerId(String retailerId);

	void deleteRetailerDetail(RetailerDetail retailerDetail);

	List<RetailerDetail> getSearchedRetailerByFirstName(String searchKey);
	List<RetailerDetail> getSearchedRetailerByLastName(String searchKey);

}
