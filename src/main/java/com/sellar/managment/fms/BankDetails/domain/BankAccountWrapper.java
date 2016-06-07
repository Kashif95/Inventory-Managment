/**
 * 
 */
package com.sellar.managment.fms.BankDetails.domain;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author rakumari
 *
 */
public class BankAccountWrapper {
	
	private String bankAccountNumber;
	
	private String IfscCode;
	
	private String bankName;
	
	private String branchName;

	/**
	 * @return the bankAccountNumber
	 */
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	/**
	 * @param bankAccountNumber the bankAccountNumber to set
	 */
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return IfscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		IfscCode = ifscCode;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	

}
