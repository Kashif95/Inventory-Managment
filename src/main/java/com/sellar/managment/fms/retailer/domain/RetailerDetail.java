/**
 * 
 */
package com.sellar.managment.fms.retailer.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sellar.managment.fms.BankDetails.domain.BankAccountDetails;
import com.sellar.managment.fms.user.domain.AddressDetail;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="RetailerDetails")
public class RetailerDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="RetailerId", unique=true)
	private int retailerId;
	
	@Column(name="RetailerFName")
	private String retailerFirstName;
	
	@Column(name="RetailerLName")
	private String retailerLastName;
	
	@Column(name="RetailerPanNumber")
	private String retailerPanNumber;
	
	@Column(name="RetailerEmail")
	private String email;
	
	@Column(name="PrimaryContactNumber")
	private String mobileNumber;
	
	@Column(name="AlternateContactNumber")
	private String alternateNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="AddressId")
	private AddressDetail address;
	
	@Column(name="UserTypeId")
	private short userTypeId;
	
	@Column(name = "RdCrd")
	private Date createdOn;
    
    @Column(name = "RdCrdBy")
	private String createdBy;
    
    @Column(name = "RdUpd")
    private Date updOn;
    
    @Column(name = "RdUpdBy")
	private String updBy;

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
	 * @return the retailerFirstName
	 */
	public String getRetailerFirstName() {
		return retailerFirstName;
	}

	/**
	 * @param retailerFirstName the retailerFirstName to set
	 */
	public void setRetailerFirstName(String retailerFirstName) {
		this.retailerFirstName = retailerFirstName;
	}

	/**
	 * @return the retailerLastName
	 */
	public String getRetailerLastName() {
		return retailerLastName;
	}

	/**
	 * @param retailerLastName the retailerLastName to set
	 */
	public void setRetailerLastName(String retailerLastName) {
		this.retailerLastName = retailerLastName;
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
	 * @return the address
	 */
	public AddressDetail getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDetail address) {
		this.address = address;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updOn
	 */
	public Date getUpdOn() {
		return updOn;
	}

	/**
	 * @param updOn the updOn to set
	 */
	public void setUpdOn(Date updOn) {
		this.updOn = updOn;
	}

	/**
	 * @return the updBy
	 */
	public String getUpdBy() {
		return updBy;
	}

	/**
	 * @param updBy the updBy to set
	 */
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	/**
	 * @return the userTypeId
	 */
	public short getUserTypeId() {
		return userTypeId;
	}

	/**
	 * @param userTypeId the userTypeId to set
	 */
	public void setUserTypeId(short userTypeId) {
		this.userTypeId = userTypeId;
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
