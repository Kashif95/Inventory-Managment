/**
 * 
 */
package com.sellar.managment.fms.order.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.sellar.managment.fms.inventory.domain.ProductStock;
import com.sellar.managment.medicine.order.domain.MedicineOrderDetail;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="OrderedProductDetails")
public class OrderedProduct {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator="generator") 
	@Column(name="OPDId", unique=true)
	private String orderedProductId;
	
	@Column(name="OrderId")
	private Integer orderId;
	
	@Column(name="ProductStockId")
	private int stockId;
	
	@Column(name="Quantity")
	private float quantity;
	
	@Column(name="Price")
	private float price;
	
	@Column(name="MedicineOrderId")
	private Integer medicineOrderId;
	
	@JsonIgnore
	@Column(name = "OPDCrd")
	private Date createdOn;
    
	@JsonIgnore
    @Column(name = "OPDCrdBy")
	private String createdBy;
    
	@JsonIgnore
    @Column(name = "OPDUpd")
    private Date updOn;
    
	@JsonIgnore
    @Column(name = "OPDUpdBy")
	private String updBy; 
    
    @ManyToOne(targetEntity = OrderDetail.class)
    @JoinColumn(name = "OrderId", referencedColumnName = "OrderId", insertable = false, updatable = false)
    private OrderDetail orderDetail;
    
    @ManyToOne(targetEntity = MedicineOrderDetail.class)
    @JoinColumn(name = "MedicineOrderId", referencedColumnName = "OrderId", insertable = false, updatable = false)
    private MedicineOrderDetail medicineOrderDetail;
    
    @ManyToOne(targetEntity = ProductStock.class)
    @JoinColumn(name = "ProductStockId", referencedColumnName = "ProductStockId", insertable = false, updatable = false)
    private ProductStock productStock;

	/**
	 * @return the orderedProductId
	 */
	public String getOrderedProductId() {
		return orderedProductId;
	}

	/**
	 * @param orderedProductId the orderedProductId to set
	 */
	public void setOrderedProductId(String orderedProductId) {
		this.orderedProductId = orderedProductId;
	}

	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
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
	 * @return the orderDetails
	 */
	public OrderDetail getOrderDetails() {
		return orderDetail;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(OrderDetail orderDetails) {
		this.orderDetail = orderDetails;
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

	/**
	 * @return the productStock
	 */
	public ProductStock getProductStock() {
		return productStock;
	}

	/**
	 * @param productStock the productStock to set
	 */
	public void setProductStock(ProductStock productStock) {
		this.productStock = productStock;
	}

	/**
	 * @return the medicineOrderId
	 */
	public Integer getMedicineOrderId() {
		return medicineOrderId;
	}

	/**
	 * @param medicineOrderId the medicineOrderId to set
	 */
	public void setMedicineOrderId(Integer medicineOrderId) {
		this.medicineOrderId = medicineOrderId;
	}
	
	
	
	
	
	
    
    
	
	
	
	

}
