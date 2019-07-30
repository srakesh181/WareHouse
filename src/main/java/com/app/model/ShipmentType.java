package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipment_type_tab")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name="shipmentTypeId")
	private Integer shipmentTypeId;
	@Column(name="smode")
	private String shipmentMode;
	@Column(name="scode")
	private String shipmentCode;
	@Column(name="enableship")
	private String enableShipment;
	@Column(name="sgrade")
	private String shipmentGrade;
	@Column(name="Description")
	private String description;

	//default constructor
	public ShipmentType() {
		super();
	}

	
	// single param constructor
	public ShipmentType(Integer shipmentTypeId) {
		super();
		this.shipmentTypeId = shipmentTypeId;
	}

	//setter and getters
	
	public Integer getShipmentTypeId() {
		return shipmentTypeId;
	}


	public void setShipmentTypeId(Integer shipmentTypeId) {
		this.shipmentTypeId = shipmentTypeId;
	}


	public String getShipmentMode() {
		return shipmentMode;
	}


	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}


	public String getShipmentCode() {
		return shipmentCode;
	}


	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}


	public String getEnableShipment() {
		return enableShipment;
	}


	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}


	public String getShipmentGrade() {
		return shipmentGrade;
	}


	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	//AllParamConstructor
	public ShipmentType(Integer shipmentTypeId, String shipmentMode, String shipmentCode, String enableShipment,
			String shipmentGrade, String description) {
		super();
		this.shipmentTypeId = shipmentTypeId;
		this.shipmentMode = shipmentMode;
		this.shipmentCode = shipmentCode;
		this.enableShipment = enableShipment;
		this.shipmentGrade = shipmentGrade;
		this.description = description;
	}

	//toString
	public String toString() {
		return "ShipmentType [shipmentTypeId=" + shipmentTypeId + ", shipmentMode=" + shipmentMode + ", shipmentCode="
				+ shipmentCode + ", enableShipment=" + enableShipment + ", shipmentGrade=" + shipmentGrade
				+ ", description=" + description + "]";
	}
}
