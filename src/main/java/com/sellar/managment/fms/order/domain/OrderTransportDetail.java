/**
 * 
 */
package com.sellar.managment.fms.order.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author rakumari
 *
 */
@Entity
@Table(name="OrderTranportDetail")
public class OrderTransportDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="OTDId",unique=true)
	private int transportDetailId;
	
	@Column(name="OrderId")
	private Integer orderId;
	
	@Column(name="SourceLocation")
	private String sourceLoaction;
	
	@Column(name="DestinationLocation")
	private String destinationLocation;
	
	@Column(name="VehicleNumber")
	private String vehicleNumber;
	
	@Column(name="TransportMode")
	private String transportMode;
	
	@JsonIgnore
	@Column(name = "OTDCrd")
	private Date createdOn;
    
	@JsonIgnore
    @Column(name = "OTDCrdBy")
	private String createdBy;
    
	@JsonIgnore
    @Column(name = "OTDUpd")
    private Date updOn;
    
	@JsonIgnore
    @Column(name = "OTDUpdBy")
	private String updBy; 

	/**
	 * @return the transportDetailId
	 */
	public int getTransportDetailId() {
		return transportDetailId;
	}

	/**
	 * @param transportDetailId the transportDetailId to set
	 */
	public void setTransportDetailId(int transportDetailId) {
		this.transportDetailId = transportDetailId;
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
	 * @return the sourceLoaction
	 */
	public String getSourceLoaction() {
		return sourceLoaction;
	}

	/**
	 * @param sourceLoaction the sourceLoaction to set
	 */
	public void setSourceLoaction(String sourceLoaction) {
		this.sourceLoaction = sourceLoaction;
	}

	/**
	 * @return the destinationLocation
	 */
	public String getDestinationLocation() {
		return destinationLocation;
	}

	/**
	 * @param destinationLocation the destinationLocation to set
	 */
	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	/**
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return the transportMode
	 */
	public String getTransportMode() {
		return transportMode;
	}

	/**
	 * @param transportMode the transportMode to set
	 */
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
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
	
	
	
	
    
	
	
	

}
