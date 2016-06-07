/**
 * 
 */
package com.sellar.managment.fms.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="UserCompanyType")
public class UserCompanyType implements Serializable{
	
		@Id
	    @Column(name = "UserCompTypeId")
	    private int id;

	    /**
	     * It represents the user type name.
	     */
	    @Column(name = "Descr")
	    private String description;

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}
	    
	    
	    
	    

}
