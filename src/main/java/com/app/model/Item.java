package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_tab")
public class Item {
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Integer itemId;
	@Column(name="item_code")
	private String itemCode;
	@Column(name="item_width")
	private Double itemWidth;
	@Column(name="item_length")
	private Double itemLength;
	@Column(name="item_height")
	private Double itemHeight;
	@Column(name="item_basecost")
	private Double itemBaseCost;
	@Column(name="item_basecurrency")
	private String itemBaseCurrency;

	//default constructor
	public Item() {
		super();
	}

	//single param constructor
	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}

	//all param constructor
	public Item(Integer itemId, String itemCode, Double itemWidth, Double itemLength, Double itemHeight,
			Double itemBaseCost, String itemBaseCurrency) {
		super();
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemWidth = itemWidth;
		this.itemLength = itemLength;
		this.itemHeight = itemHeight;
		this.itemBaseCost = itemBaseCost;
		this.itemBaseCurrency = itemBaseCurrency;
	}

	//setters and getters
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Double getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(Double itemWidth) {
		this.itemWidth = itemWidth;
	}

	public Double getItemLength() {
		return itemLength;
	}

	public void setItemLength(Double itemLength) {
		this.itemLength = itemLength;
	}

	public Double getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(Double itemHeight) {
		this.itemHeight = itemHeight;
	}

	public Double getItemBaseCost() {
		return itemBaseCost;
	}

	public void setItemBaseCost(Double itemBaseCost) {
		this.itemBaseCost = itemBaseCost;
	}

	public String getItemBaseCurrency() {
		return itemBaseCurrency;
	}

	public void setItemBaseCurrency(String itemBaseCurrency) {
		this.itemBaseCurrency = itemBaseCurrency;
	}

	//toString
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemWidth=" + itemWidth + ", itemLength="
				+ itemLength + ", itemHeight=" + itemHeight + ", itemBaseCost=" + itemBaseCost + ", itemBaseCurrency="
				+ itemBaseCurrency + "]";
	}

}
