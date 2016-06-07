/**
 * 
 */
package com.sellar.managment.fms.BankDetails;

import com.sellar.managment.fms.BankDetails.domain.BankAccountDetails;

/**
 * @author rakumari
 *
 */
public interface BankDetailsDAO {
	
	void saveBankDetails(BankAccountDetails bankAccountDetails);

}
