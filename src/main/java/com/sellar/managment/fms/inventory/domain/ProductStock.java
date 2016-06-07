/**
 * 
 */
package com.sellar.managment.fms.inventory.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.sellar.managment.fms.agency.domain.AgencyDetail;
import com.sellar.managment.fms.product.domain.ProductDetail;
import com.sellar.managment.fms.user.domain.UserCompanyType;
import com.sellar.managment.medicine.agency.domain.MedicalAgencyDetail;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="ProductStock")
public class ProductStock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="ProductStockId", unique=true)
	private int productStockId;
	
	@Column(name="ProductId")
	private int productId;

	
	@Column(name="AgencyId")
	private Integer agencyId;
	
	@Column(name="Quantity")
	private float quantity;
	
	@Column(name="CostPrice")
	private float costPrice;
	
	@Column(name="SellingPrice")
	private float sellingPrice;
	
	@Column(name="ArrivalDate")
	private Date arrivalDate;
	
	@Column(name="UserCompTypeId")
	private short companyTypeId;
	
	@Column(name="MedicineAgencyId")
	private Integer medicineAgencyId;
	
	
	@JsonIgnore
	@Column(name = "PsCrd")
	private Date createdOn;
    
	@JsonIgnore
    @Column(name = "PsCrdBy")
	private String createdBy;
    
    @Column(name = "PsUpd")
    private Date updOn;
    
    @Column(name = "PsUpdBy")
	private String updBy;
    
    @Column(name="ExpiryDate")
	private Date expiryDate;
	
    
    @ManyToOne(targetEntity = AgencyDetail.class)
    @JoinColumn(name = "AgencyId", referencedColumnName = "AgencyId", insertable = false, updatable = false)
    private AgencyDetail agencyDetail;
    
    @ManyToOne(targetEntity = MedicalAgencyDetail.class)
    @JoinColumn(name = "MedicineAgencyId", referencedColumnName = "AgencyId", insertable = false, updatable = false)
    private MedicalAgencyDetail medicineAgencyDetail;
    
    @ManyToOne(targetEntity = ProductDetail.class)
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId", insertable = false, updatable = false)
    private ProductDetail productDetail;
    
    @ManyToOne(targetEntity = UserCompanyType.class)
    @JoinColumn(name = "UserCompTypeId", referencedColumnName = "UserCompTypeId", insertable = false, updatable = false)
    private UserCompanyType companyType;

	/**
	 * @return the productStockId
	 */
	public int getProductStockId() {
		return productStockId;
	}

	/**
	 * @param productStockId the productStockId to set
	 */
	public void setProductStockId(int productStockId) {
		this.productStockId = productStockId;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the agencyId
	 */
	public Integer getAgencyId() {
		return agencyId;
	}

	/**
	 * @param agencyId the agencyId to set
	 */
	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
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
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
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
	 * @return the agencyDetail
	 */
	public AgencyDetail getAgencyDetail() {
		return agencyDetail;
	}

	/**
	 * @param agencyDetail the agencyDetail to set
	 */
	public void setAgencyDetail(AgencyDetail agencyDetail) {
		this.agencyDetail = agencyDetail;
	}

	/**
	 * @return the productDetail
	 */
	public ProductDetail getProductDetail() {
		return productDetail;
	}

	/**
	 * @param productDetail the productDetail to set
	 */
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	/**
	 * @return the costPrice
	 */
	public float getCostPrice() {
		return costPrice;
	}

	/**
	 * @param costPrice the costPrice to set
	 */
	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

	/**
	 * @return the sellingPrice
	 */
	public float getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * @return the companyTypeId
	 */
	public short getCompanyTypeId() {
		return companyTypeId;
	}

	/**
	 * @param companyTypeId the companyTypeId to set
	 */
	public void setCompanyTypeId(short companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the medicineAgencyId
	 */
	public Integer getMedicineAgencyId() {
		return medicineAgencyId;
	}

	/**
	 * @param medicineAgencyId the medicineAgencyId to set
	 */
	public void setMedicineAgencyId(Integer medicineAgencyId) {
		this.medicineAgencyId = medicineAgencyId;
	}

	/**
	 * @return the medicineAgencyDetail
	 */
	public MedicalAgencyDetail getMedicineAgencyDetail() {
		return medicineAgencyDetail;
	}

	/**
	 * @param medicineAgencyDetail the medicineAgencyDetail to set
	 */
	public void setMedicineAgencyDetail(MedicalAgencyDetail medicineAgencyDetail) {
		this.medicineAgencyDetail = medicineAgencyDetail;
	}
	
	
	
	
	
	
	
	
	
	
    
    
    

}
