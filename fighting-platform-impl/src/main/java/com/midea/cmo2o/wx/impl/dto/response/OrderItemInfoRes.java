package com.midea.cmo2o.wx.impl.dto.response;

import java.math.BigDecimal;

public class OrderItemInfoRes {

	// item编码
	private String shortCode;

	// 商品名称
	private String itemName;

	// 商品品牌
	private String productBrand;

	// 商品单价
	private BigDecimal itemPrice;

	// 购买数量
	private short itemCnt;

	/**
	 * 商品特性
	 */
	private Byte productAttr;

	public Byte getProductAttr() {
		return productAttr;
	}

	public void setProductAttr(Byte productAttr) {
		this.productAttr = productAttr;
	}

	public String getProductAttrName() {
		if (this.productAttr == 1) {
			return "特价机";
		} else {
			return "常规机";
		}
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public short getItemCnt() {
		return itemCnt;
	}

	public void setItemCnt(short itemCnt) {
		this.itemCnt = itemCnt;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

}
