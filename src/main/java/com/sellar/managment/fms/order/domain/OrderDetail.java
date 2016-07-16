/**
 * 
 */
package com.sellar.managment.fms.order.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sellar.managment.fms.order.OrderStatus;
import com.sellar.managment.fms.retailer.domain.RetailerDetail;
import com.sellar.managment.fms.user.domain.UserType;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="OrderDetail")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="OrderId",unique=true)
	private int orderId;
	
	@Column(name="OrderPrice")
	private float orderPrice;
	
	@Column(name="LabourFee")
	private float labourFee;
	
	@Column(name="ShippingFee")
	private float shippingFee;
	
	@Column(name="OrderTotalPrice")
	private float orderTotalPrice;
	
	@Column(name="RetailerId")
	private int retailerId;
	
	@Column(name="PaymentMode")
	private String paymentMode;
	
	@Column(name="PaymentStatus")
	private boolean paymentStatus;
	
	@Column(name="OrderStatusTypeId")
	private short orderStatusTypeId;
	
	@Column(name="PendingAmount")
	private float pendingAmount;
	
	@Column(name="ChallanNumber")
	private String challanNumber;
	
	@Column(name="ChallanDate")
	private Date challanDate;
	
	
	@Column(name = "ODCrd")
	private Date createdOn;
    
    @Column(name = "ODCrdBy")
	private String createdBy;
    
    @Column(name = "ODUpd")
    private Date updOn;
    
    @Column(name = "ODUpdBy")
	private String updBy;
    
    @OneToOne(targetEntity = RetailerDetail.class)
    @JoinColumn(name = "RetailerId", referencedColumnName = "RetailerId", insertable = false, updatable = false)
    private RetailerDetail retailerDetail;
    
    @ManyToOne(targetEntity = OrderStatus.class)
    @JoinColumn(name = "OrderStatusTypeId", referencedColumnName = "OrderStatusTypeId", insertable = false, updatable = false)
    private OrderStatus orderStatus;
	

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
	 * @return the orderPrice
	 */
	public float getOrderPrice() {
		return orderPrice;
	}

	/**
	 * @param orderPrice the orderPrice to set
	 */
	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
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
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the paymentStatus
	 */
	public boolean getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * @return the retailerDetail
	 */
	public RetailerDetail getRetailerDetail() {
		return retailerDetail;
	}

	/**
	 * @param retailerDetail the retailerDetail to set
	 */
	public void setRetailerDetail(RetailerDetail retailerDetail) {
		this.retailerDetail = retailerDetail;
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
	 * @return the labourFee
	 */
	public float getLabourFee() {
		return labourFee;
	}

	/**
	 * @param labourFee the labourFee to set
	 */
	public void setLabourFee(float labourFee) {
		this.labourFee = labourFee;
	}

	/**
	 * @return the shippingFee
	 */
	public float getShippingFee() {
		return shippingFee;
	}

	/**
	 * @param shippingFee the shippingFee to set
	 */
	public void setShippingFee(float shippingFee) {
		this.shippingFee = shippingFee;
	}

	/**
	 * @return the orderTotalPrice
	 */
	public float getOrderTotalPrice() {
		return orderTotalPrice;
	}

	/**
	 * @param orderTotalPrice the orderTotalPrice to set
	 */
	public void setOrderTotalPrice(float orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	/**
	 * @return the orderStatusTypeId
	 */
	public short getOrderStatusTypeId() {
		return orderStatusTypeId;
	}

	/**
	 * @param orderStatusTypeId the orderStatusTypeId to set
	 */
	public void setOrderStatusTypeId(short orderStatusTypeId) {
		this.orderStatusTypeId = orderStatusTypeId;
	}

	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the pendingAmount
	 */
	public float getPendingAmount() {
		return pendingAmount;
	}

	/**
	 * @param pendingAmount the pendingAmount to set
	 */
	public void setPendingAmount(float pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

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
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
