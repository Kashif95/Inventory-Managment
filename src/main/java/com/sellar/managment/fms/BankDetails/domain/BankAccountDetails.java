/**
 * 
 */
package com.sellar.managment.fms.BankDetails.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sellar.managment.fms.retailer.domain.RetailerDetail;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="BankAccountDetails")
public class BankAccountDetails {
	
	@Id
	@Column(name="AccountNumber",unique=true,nullable=false)
	private String bankAccountNumber;
	
	@Column(name = "IFSCCode",nullable=false)
	private String IfscCode;
	
	@Column(name = "BankName",nullable=false)
	private String bankName;
	
	@Column(name = "BranchName")
	private String branchName;
	
	@Column(name="AssociateId",nullable=false)
	private Integer associateId;
	
	@Column(name = "BadCrd")
	private Date createdOn;
    
    @Column(name = "BadCrdBy")
	private String createdBy;
    
    @Column(name = "BadUpd")
    private Date updOn;
    
    @Column(name = "BadUpdBy")
	private String updBy;

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
	 * @return the associateId
	 */
	public Integer getAssociateId() {
		return associateId;
	}

	/**
	 * @param associateId the associateId to set
	 */
	public void setAssociateId(Integer associateId) {
		this.associateId = associateId;
	}
	
	
    
    
}
