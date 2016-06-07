/**
 * 
 */
package com.sellar.managment.medicine.order.domain;

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
@Table(name="MedicineOrderDetail")
public class MedicineOrderDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="OrderId",unique=true)
	private int orderId;
	
	@Column(name="OrderPrice")
	private float orderPrice;
	
	@Column(name="DiscountFactor")
	private float discountPercentage;
	
	@Column(name="OrderTotalPrice")
	private float orderTotalPrice;
	
	@Column(name="CustomerName")
	private String customerName;
	
	@Column(name="CustomerMobile")
	private String customerMobile;
	
	@Column(name="PaymentMode")
	private String paymentMode;
	
	@Column(name="PaymentStatus")
	private boolean paymentStatus;
	
	@Column(name="OrderStatusTypeId")
	private short orderStatusTypeId;
	
	@Column(name="BalanceAmount")
	private float balanceAmount;
	
	@Column(name="Payment")
	private float payment;
	
	@Column(name="BillNumber")
	private String billNumber;
	
	@Column(name="BillDate")
	private Date billDate;
	
	
	@Column(name = "ODCrd")
	private Date createdOn;
    
    @Column(name = "ODCrdBy")
	private String createdBy;
    
    @Column(name = "ODUpd")
    private Date updOn;
    
    @Column(name = "ODUpdBy")
	private String updBy;
    
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
	 * @return the discountPercentage
	 */
	public float getDiscountPercentage() {
		return discountPercentage;
	}

	/**
	 * @param discountPercentage the discountPercentage to set
	 */
	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerMobile
	 */
	public String getCustomerMobile() {
		return customerMobile;
	}

	/**
	 * @param customerMobile the customerMobile to set
	 */
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	/**
	 * @return the balanceAmount
	 */
	public float getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * @param balanceAmount the balanceAmount to set
	 */
	public void setBalanceAmount(float balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * @return the payment
	 */
	public float getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(float payment) {
		this.payment = payment;
	}

	/**
	 * @return the billNumber
	 */
	public String getBillNumber() {
		return billNumber;
	}

	/**
	 * @param billNumber the billNumber to set
	 */
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	/**
	 * @return the billDate
	 */
	public Date getBillDate() {
		return billDate;
	}

	/**
	 * @param billDate the billDate to set
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
	
	
	
	
	
	
	
	

}
