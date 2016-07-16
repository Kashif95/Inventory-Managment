/**
 * 
 */
package com.sellar.managment.fms.inventory.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.sellar.managment.fms.agency.domain.AgencyDetail;
import com.sellar.managment.fms.util.CustomDateAndTimeFormat;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="ProductStockMiscDetails")
public class ProductStockMiscDetails {
	
	@Id
	@Column(name="ProductStockId", unique = true, nullable = false)
	private int stockId;
	
	@Column(name="ChallanNumber")
	private String challanNumber;
	
	@JsonDeserialize(using=CustomDateAndTimeFormat.class)
	@Column(name="ChallanDate")
	private Date challanDate;
	
	@Column(name="InvoiceNumber")
	private String invoiceNumber;
	
	@JsonDeserialize(using=CustomDateAndTimeFormat.class)
	@Column(name="InvoiceDate")
	private Date invoiceDate;
	
	@Column(name="DONumber")
	private String doNumber;
	
	@JsonDeserialize(using=CustomDateAndTimeFormat.class)
	@Column(name="DueDate")
	private Date dueDate;
	
	
	@JsonIgnore
	@Column(name = "PSMDCrd")
	private Date createdOn;
    
	@JsonIgnore
    @Column(name = "PSMDCrdBy")
	private String createdBy;
    
    @Column(name = "PSMDUpd")
    private Date updOn;
    
    @Column(name = "PSMDUpdBy")
	private String updBy;
    

	/**
	 * @return the stockMiscId
	 *//*
	public int getStockMiscId() {
		return stockMiscId;
	}

	*//**
	 * @param stockMiscId the stockMiscId to set
	 *//*
	public void setStockMiscId(int stockMiscId) {
		this.stockMiscId = stockMiscId;
	}*/

	/**
	 * @return the challanNumber
	 */
	public String getChallanNumber() {
		return challanNumber;
	}

	/**
	 * @param challanNumber the challanNumber to set
	 */
	public void setChallanNumber(String challanNumber) {
		this.challanNumber = challanNumber;
	}

	/**
	 * @return the challanDate
	 */
	public Date getChallanDate() {
		return challanDate;
	}

	/**
	 * @param challanDate the challanDate to set
	 */
	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}

	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * @param invoiceNumber the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * @return the invoiceDate
	 */
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	/**
	 * @param invoiceDate the invoiceDate to set
	 */
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	/**
	 * @return the doNumber
	 */
	public String getDoNumber() {
		return doNumber;
	}

	/**
	 * @param doNumber the doNumber to set
	 */
	public void setDoNumber(String doNumber) {
		this.doNumber = doNumber;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
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

	
	
	
	
	
	
	
	
	

}
