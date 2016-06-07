/**
 * 
 */
package com.sellar.managment.fms.transaction.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.sellar.managment.fms.order.domain.OrderDetail;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="PaymentDetail")
public class PaymentDetail {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator="generator") 
	@Column(name="PDId", unique=true)
	private String paymentId;
	
	@Column(name="OrderId")
	private int orderId;
	
	@Column(name="BankName")
	private String bankName;
	
	@Column(name="TransactionId")
	private String transactionId;
	
	@Column(name="AmountPaid")
	private float amountPaid;
	
	@Column(name="TransactionDate")
	private Date transactionDate;
	
	@JsonIgnore
	@Column(name = "PDCrd")
	private Date createdOn;
    
	@JsonIgnore
    @Column(name = "PDCrdBy")
	private String createdBy;
    
	@JsonIgnore
    @Column(name = "PDUpd")
    private Date updOn;
    
	@JsonIgnore
    @Column(name = "PDUpdBy")
	private String updBy; 
    
    @OneToOne(targetEntity = OrderDetail.class)
    @JoinColumn(name = "OrderId", referencedColumnName = "OrderId", insertable = false, updatable = false)
    private OrderDetail orderDetail;

	

	/**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the amountPaid
	 */
	public float getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
	 * @return the orderDetail
	 */
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	/**
	 * @param orderDetail the orderDetail to set
	 */
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
    
    

}
