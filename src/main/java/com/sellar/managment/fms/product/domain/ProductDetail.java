/**
 * 
 */
package com.sellar.managment.fms.product.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sellar.managment.fms.agency.domain.AgencyDetail;
import com.sellar.managment.fms.user.domain.UserCompanyType;
import com.sellar.managment.medicine.agency.domain.MedicalAgencyDetail;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="ProductDetails")
public class ProductDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="ProductId", unique=true)
	private int productId;
	
	@Column(name="ProductName")
	private String productName;

	
	@Column(name="AgencyId")
	private Integer agencyId;
	
	@Column(name="TypeId")
	private short typeId;
	
	@Column(name="MedicineAgencyId")
	private Integer medicineAgencyId;
	
	@Column(name="UserCompTypeId")
	private short companyTypeId;
	
	@Column(name = "PdCrd")
	private Date createdOn;
    
    @Column(name = "PdCrdBy")
	private String createdBy;
    
    @Column(name = "PdUpd")
    private Date updOn;
    
    @Column(name = "PdUpdBy")
	private String updBy;
    
    @ManyToOne(targetEntity = AgencyDetail.class)
    @JoinColumn(name = "AgencyId", referencedColumnName = "AgencyId", insertable = false, updatable = false)
    private AgencyDetail agencyDetail;
    
    @ManyToOne(targetEntity = ProductType.class)
    @JoinColumn(name = "TypeId", referencedColumnName = "TypeId", insertable = false, updatable = false)
    private ProductType productType;
    
    @ManyToOne(targetEntity = MedicalAgencyDetail.class)
    @JoinColumn(name = "MedicineAgencyId", referencedColumnName = "AgencyId", insertable = false, updatable = false)
    private MedicalAgencyDetail medicineAgencyDetail;
    
    @ManyToOne(targetEntity = UserCompanyType.class)
    @JoinColumn(name = "UserCompTypeId", referencedColumnName = "UserCompTypeId", insertable = false, updatable = false)
    private UserCompanyType companyType;

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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * @return the typeId
	 */
	public short getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(short typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
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

	/**
	 * @return the companyType
	 */
	public UserCompanyType getCompanyType() {
		return companyType;
	}

	/**
	 * @param companyType the companyType to set
	 */
	public void setCompanyType(UserCompanyType companyType) {
		this.companyType = companyType;
	}
	
	
	
	
	
	
    
    


}
