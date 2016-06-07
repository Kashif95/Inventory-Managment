/**
 * 
 */
package com.sellar.managment.fms.agency.domain;

import java.util.Date;

import javax.persistence.CascadeType;
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

import com.sellar.managment.fms.user.domain.AddressDetail;

/**
 * @author rakumari
 *
 */

@Entity
@Table(name="AgencyDetails")
public class AgencyDetail {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO) 
		@Column(name="AgencyId", unique=true)
		private Integer agencyId;
		
		@Column(name="AgencyName")
		private String agencyName;
		
		@Column(name="AgencyOwnerName")
		private String ownerName;
		
		@Column(name="AgencySupervisorName")
		private String agencySupervisor;
		
		@Column(name="AgencyEmail")
		private String email;
		
		@Column(name="PrimaryContactNumber")
		private String mobileNumber;
		
		@Column(name="AlternateContactNumber")
		private String alternateNumber;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="AddressId")
		private AddressDetail address;
		
		@Column(name = "AdCrd")
		private Date createdOn;
	    
	    @Column(name = "AdCrdBy")
		private String createdBy;
	    
	    @Column(name = "AdUpd")
	    private Date updOn;
	    
	    @Column(name = "AdUpdBy")
		private String updBy;

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
		 * @return the agencyName
		 */
		public String getAgencyName() {
			return agencyName;
		}

		/**
		 * @param agencyName the agencyName to set
		 */
		public void setAgencyName(String agencyName) {
			this.agencyName = agencyName;
		}

		/**
		 * @return the ownerName
		 */
		public String getOwnerName() {
			return ownerName;
		}

		/**
		 * @param ownerName the ownerName to set
		 */
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}

		/**
		 * @return the agencySupervisor
		 */
		public String getAgencySupervisor() {
			return agencySupervisor;
		}

		/**
		 * @param agencySupervisor the agencySupervisor to set
		 */
		public void setAgencySupervisor(String agencySupervisor) {
			this.agencySupervisor = agencySupervisor;
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
		@JsonIgnore
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
		@JsonIgnore
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
		@JsonIgnore
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
		@JsonIgnore
		public void setUpdBy(String updBy) {
			this.updBy = updBy;
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
