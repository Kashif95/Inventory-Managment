package com.sellar.managment.fms.login.domain;

/**
 * 
 */

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sellar.managment.fms.user.domain.UserDetails;




/**
 * @author rakumari
 *
 */
@Entity
@Table(name = "LoginDetails")
public class LoginDetails {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator="generator")
	@Column(name = "LoginId", unique = true, nullable = false)
	private String loginId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UserId")
	private UserDetails userDetails;
	
	@Column(name = "LdCrd")
	private Date createdOn;
    
    @Column(name = "LdCrdBy")
	private String createdBy;
    
    @Column(name = "LdUpd")
    private Date UpdOn;
    
    @Column(name = "LdUpdBy")
	private String UpdBy;


	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}


	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
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
		return UpdOn;
	}

	/**
	 * @param updOn the updOn to set
	 */
	public void setUpdOn(Date updOn) {
		UpdOn = updOn;
	}


	/**
	 * @return the updBy
	 */
	public String getUpdBy() {
		return UpdBy;
	}


	/**
	 * @param updBy the updBy to set
	 */
	public void setUpdBy(String updBy) {
		UpdBy = updBy;
	}


	/**
	 * @return the userDetails
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}


	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
	
	

}
