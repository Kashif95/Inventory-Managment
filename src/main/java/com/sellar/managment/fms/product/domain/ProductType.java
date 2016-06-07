/**
 * 
 */
package com.sellar.managment.fms.product.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sellar.managment.fms.user.domain.UserCompanyType;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="ProductType")
public class ProductType {
	
	
		@Id
		@Column(name="TypeId")
		private int typeId;
		
		@Column(name="Description")
		private String typeDesc;
		
		@Column(name="UserCompTypeId")
		private short companyTypeId;
		

		/**
		 * @return the typeId
		 */
		public int getTypeId() {
			return typeId;
		}

		/**
		 * @param typeId the typeId to set
		 */
		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}

		/**
		 * @return the typeDesc
		 */
		public String getTypeDesc() {
			return typeDesc;
		}

		/**
		 * @param typeDesc the typeDesc to set
		 */
		public void setTypeDesc(String typeDesc) {
			this.typeDesc = typeDesc;
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
		
		

}
