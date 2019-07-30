package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uom_tab")
public class Uom {
	@Id
	@GeneratedValue
	@Column(name="uomId")
	private Integer uomId;
	@Column(name="uomType")
	private String uomType;
	@Column(name="uomModel")
	private String uomModel;
	@Column(name="uomDescription")
	private String uomDescription;
	
	//default constructor
	public Uom() {
		super();
	}

	
	//single param constructor
	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}

	//setters and getters
	public Integer getUomId() {
		return uomId;
	}


	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}


	public String getUomType() {
		return uomType;
	}


	public void setUomType(String uomType) {
		this.uomType = uomType;
	}


	public String getUomModel() {
		return uomModel;
	}


	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}


	public String getUomDescription() {
		return uomDescription;
	}


	public void setUomDescription(String uomDescription) {
		this.uomDescription = uomDescription;
	}


	
	//toString
	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDescription="
				+ uomDescription + "]";
	}

	// all parameterised constructor
	public Uom(Integer uomId, String uomType, String uomModel, String uomDescription) {
		super();
		this.uomId = uomId;
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.uomDescription = uomDescription;
	}
	
	
	
}
