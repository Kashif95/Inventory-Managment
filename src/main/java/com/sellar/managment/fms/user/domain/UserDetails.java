/**
 * 
 */
package com.sellar.managment.fms.user.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="UserDetails")
public class UserDetails implements Serializable{
	
	@Id
	@Column(name="MobileNumber")
	private String mobileNumber;
	
	@Column(name="UserFName")
	private String userFirstName;
	
	@Column(name="UserLName")
	private String userLastName;
	
	@Column(name="UserEmail")
	private String userEmail;
	
	@Column(name = "UserPassword") 
	private String password;
	
	@Column(name = "ConfirmPassword") 
	private String confirmPassword;
	
	@Column(name="UserTypeId")
	private short userTypeId;
	
	@Column(name="UserCompTypeId")
	private short userCompTypeId;
	
	@Column(name = "UdCrd")
	private Date createdOn;
    
    @Column(name = "UdCrdBy")
	private String createdBy;
    
    @Column(name = "UdUpd")
    private Date updOn;
    
    @Column(name = "UdUpdBy")
	private String updBy;
    
    @ManyToOne(targetEntity = UserType.class)
    @JoinColumn(name = "UserTypeId", referencedColumnName = "UserTypeId", insertable = false, updatable = false)
    private UserType userType;
    
    @ManyToOne(targetEntity = UserCompanyType.class)
    @JoinColumn(name = "UserCompTypeId", referencedColumnName = "UserCompTypeId", insertable = false, updatable = false)
    private UserCompanyType userCompType;
    

	

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the userFirstName
	 */
	public String getUserFirstName() {
		return userFirstName;
	}

	/**
	 * @param userFirstName the userFirstName to set
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}

	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
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
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	/**
	 * @return the userTypeId
	 */
	public short getUserTypeId() {
		return userTypeId;
	}

	/**
	 * @param userTypeId the userTypeId to set
	 */
	public void setUserTypeId(short userTypeId) {
		this.userTypeId = userTypeId;
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
	 * @return the userCompTypeId
	 */
	public short getUserCompTypeId() {
		return userCompTypeId;
	}

	/**
	 * @param userCompTypeId the userCompTypeId to set
	 */
	public void setUserCompTypeId(short userCompTypeId) {
		this.userCompTypeId = userCompTypeId;
	}
	
	
	
	

	
	
	
	
	 
	
	

}
