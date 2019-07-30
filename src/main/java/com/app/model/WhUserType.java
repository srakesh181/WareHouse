package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertype_tab")
public class WhUserType {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer whUserTypeId;
	@Column(name="UType")
	private String whUserType;
	@Column(name="UCode")
	private String whUserCode;
	@Column(name="UFor")
	private String whUserFor;
	@Column(name="uuEmail")
	private String whUserEmail;
	@Column(name="UContact")
	private String whuserContact;
	@Column(name="IdType")
	private String whUserIdType;
	@Column(name="idNumber")
	private String whUserIdNumber;
	
	//default constructor
	public WhUserType() {
		super();
	}
	
	
	//single parameterized constructor
	public WhUserType(Integer whUserTypeId) {
		super();
		this.whUserTypeId = whUserTypeId;
	}


	// all parameterized constructor
	public WhUserType(Integer whUserTypeId, String whUserType, String whUserCode, String whUserFor, String whUserEmail,
			String whuserContact, String whUserIdType, String whUserIdNumber) {
		super();
		this.whUserTypeId = whUserTypeId;
		this.whUserType = whUserType;
		this.whUserCode = whUserCode;
		this.whUserFor = whUserFor;
		this.whUserEmail = whUserEmail;
		this.whuserContact = whuserContact;
		this.whUserIdType = whUserIdType;
		this.whUserIdNumber = whUserIdNumber;
	}
	
	//setters and getters

	public Integer getWhUserTypeId() {
		return whUserTypeId;
	}


	public void setWhUserTypeId(Integer whUserTypeId) {
		this.whUserTypeId = whUserTypeId;
	}


	public String getWhUserType() {
		return whUserType;
	}


	public void setWhUserType(String whUserType) {
		this.whUserType = whUserType;
	}


	public String getWhUserCode() {
		return whUserCode;
	}


	public void setWhUserCode(String whUserCode) {
		this.whUserCode = whUserCode;
	}


	public String getWhUserFor() {
		return whUserFor;
	}


	public void setWhUserFor(String whUserFor) {
		this.whUserFor = whUserFor;
	}


	public String getWhUserEmail() {
		return whUserEmail;
	}


	public void setWhUserEmail(String whUserEmail) {
		this.whUserEmail = whUserEmail;
	}


	public String getWhuserContact() {
		return whuserContact;
	}


	public void setWhuserContact(String whuserContact) {
		this.whuserContact = whuserContact;
	}


	public String getWhUserIdType() {
		return whUserIdType;
	}


	public void setWhUserIdType(String whUserIdType) {
		this.whUserIdType = whUserIdType;
	}


	public String getWhUserIdNumber() {
		return whUserIdNumber;
	}


	public void setWhUserIdNumber(String whUserIdNumber) {
		this.whUserIdNumber = whUserIdNumber;
	}

	//toString
	@Override
	public String toString() {
		return "WhUserType [whUserTypeId=" + whUserTypeId + ", whUserType=" + whUserType + ", whUserCode=" + whUserCode
				+ ", whUserFor=" + whUserFor + ", whUserEmail=" + whUserEmail + ", whuserContact=" + whuserContact
				+ ", whUserIdType=" + whUserIdType + ", whUserIdNumber=" + whUserIdNumber + "]";
	}
	
	
	
	
	
}
