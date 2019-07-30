package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="order_method_tab")
public class OrderMethod {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private Integer orderMethodId;
	@Column(name="order_mode")
	private String orderMethodMode;
	@Column(name="order_code")
	private String orderMethodCode;
	@Column(name="order_executiontype")
	private String orderMethodExecuteType;
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="order_accept")
	private List<String> orderMethodAccept;
	@Column(name="order_description")
	private String description;
	
	//defalut Constructor
	public OrderMethod() {
		super();
	}

	//single parameterized constructor
	public OrderMethod(Integer orderMethodId) {
		super();
		this.orderMethodId = orderMethodId;
	}

		//all parameterzied constructor
	public OrderMethod(Integer orderMethodId, String orderMethodMode, String orderMethodCode,
			String orderMethodExecuteType, List<String> orderMethodAccept, String description) {
		super();
		this.orderMethodId = orderMethodId;
		this.orderMethodMode = orderMethodMode;
		this.orderMethodCode = orderMethodCode;
		this.orderMethodExecuteType = orderMethodExecuteType;
		this.orderMethodAccept = orderMethodAccept;
		this.description = description;
	}
	
	//setters and getters

	public Integer getOrderMethodId() {
		return orderMethodId;
	}

	public void setOrderMethodId(Integer orderMethodId) {
		this.orderMethodId = orderMethodId;
	}

	public String getOrderMethodMode() {
		return orderMethodMode;
	}

	public void setOrderMethodMode(String orderMethodMode) {
		this.orderMethodMode = orderMethodMode;
	}

	public String getOrderMethodCode() {
		return orderMethodCode;
	}

	public void setOrderMethodCode(String orderMethodCode) {
		this.orderMethodCode = orderMethodCode;
	}

	public String getOrderMethodExecuteType() {
		return orderMethodExecuteType;
	}

	public void setOrderMethodExecuteType(String orderMethodExecuteType) {
		this.orderMethodExecuteType = orderMethodExecuteType;
	}

	public List<String> getOrderMethodAccept() {
		return orderMethodAccept;
	}

	public void setOrderMethodAccept(List<String> orderMethodAccept) {
		this.orderMethodAccept = orderMethodAccept;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	//toString
	@Override
	public String toString() {
		return "OrderMethod [orderMethodId=" + orderMethodId + ", orderMethodMode=" + orderMethodMode
				+ ", orderMethodCode=" + orderMethodCode + ", orderMethodExecuteType=" + orderMethodExecuteType
				+ ", orderMethodAccept=" + orderMethodAccept + ", description=" + description + "]";
	}

	
	
	
}
