/**
 * 
 */
package com.sellar.managment.fms.retailer.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.sellar.managment.fms.BankDetails.domain.BankAccountWrapper;

/**
 * @author rakumari
 *
 */
public class RetailerDetailWrapper {
	
	private String retailerFName;
	
	private String retailerLName;
	
	private String retailerPanNumber;
	
	@JsonIgnore
	private List<BankAccountWrapper> retailerBankDetails;
	
	private String email;
	
	private String mobileNumber;
	
	private String alternateNumber;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String  city;
	
	private String state;
	
	private int retailerId;
	
	private int addressId;

	

	/**
	 * @return the retailerFName
	 */
	public String getRetailerFName() {
		return retailerFName;
	}

	/**
	 * @param retailerFName the retailerFName to set
	 */
	public void setRetailerFName(String retailerFName) {
		this.retailerFName = retailerFName;
	}

	/**
	 * @return the retailerLName
	 */
	public String getRetailerLName() {
		return retailerLName;
	}

	/**
	 * @param retailerLName the retailerLName to set
	 */
	public void setRetailerLName(String retailerLName) {
		this.retailerLName = retailerLName;
	}

	/**
	 * @return the retailerPanNumber
	 */
	public String getRetailerPanNumber() {
		return retailerPanNumber;
	}

	/**
	 * @param retailerPanNumber the retailerPanNumber to set
	 */
	public void setRetailerPanNumber(String retailerPanNumber) {
		this.retailerPanNumber = retailerPanNumber;
	}

	/**
	 * @return the retailerBankDetails
	 */
	public List<BankAccountWrapper> getRetailerBankDetails() {
		return retailerBankDetails;
	}

	/**
	 * @param retailerBankDetails the retailerBankDetails to set
	 */
	//@JsonIgnore
	public void setRetailerBankDetails(List<BankAccountWrapper> retailerBankDetails) {
		this.retailerBankDetails = retailerBankDetails;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the alternateNumber
	 */
	public String getAlternateNumber() {
		return alternateNumber;
	}

	/**
	 * @param alternateNumber the alternateNumber to set
	 */
	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the retailerId
	 */
	public int getRetailerId() {
		return retailerId;
	}

	/**
	 * @param retailerId the retailerId to set
	 */
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}

	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
	
	

}
