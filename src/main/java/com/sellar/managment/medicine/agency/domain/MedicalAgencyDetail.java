/**
 * 
 */
package com.sellar.managment.medicine.agency.domain;

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


/**
 * @author rakumari
 *
 */

@Entity
@Table(name="MedicalAgencyDetails")
public class MedicalAgencyDetail {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO) 
		@Column(name="AgencyId", unique=true)
		private Integer agencyId;
		
		@Column(name="AgencyName")
		private String agencyName;
		
		
		@Column(name="AgencyEmail")
		private String agencyEmail;
		
		@Column(name="AgencyContactNumber")
		private String contactNumber;
		
		
		@Column(name="AgencyAddress")
		private String address;
		
		@JsonIgnore
		@Column(name = "AdCrd")
		private Date createdOn;
	    
		@JsonIgnore
	    @Column(name = "AdCrdBy")
		private String createdBy;
	    
		@JsonIgnore
	    @Column(name = "AdUpd")
	    private Date updOn;
	    
		@JsonIgnore
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
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}

		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}
		
		

		/**
		 * @return the agencyEmail
		 */
		public String getAgencyEmail() {
			return agencyEmail;
		}

		/**
		 * @param agencyEmail the agencyEmail to set
		 */
		public void setAgencyEmail(String agencyEmail) {
			this.agencyEmail = agencyEmail;
		}

		/**
		 * @return the contactNumber
		 */
		public String getContactNumber() {
			return contactNumber;
		}

		/**
		 * @param contactNumber the contactNumber to set
		 */
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
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
		
		
		
		
		
		

}
