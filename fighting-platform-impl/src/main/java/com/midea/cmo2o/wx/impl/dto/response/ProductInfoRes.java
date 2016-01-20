package com.midea.cmo2o.wx.impl.dto.response;

import java.math.BigDecimal;

public class ProductInfoRes {

	/**
	 * 商品活动场次编码
	 */
	private Long activityId;

	/**
	 * 商品短码
	 */
	private String shortCode;

	/**
	 * 商品品牌
	 */
	private Byte productBrand;

	/**
	 * 商品特性
	 */
	private Byte productAttribute;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 商品活动价格
	 */
	private BigDecimal discountPrice;

	/**
	 * 商品价格
	 */
	private BigDecimal price;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public Byte getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(Byte productBrand) {
		this.productBrand = productBrand;
	}

	public Byte getProductAttribute() {
		return productAttribute;
	}

	public void setProductAttribute(Byte productAttribute) {
		this.productAttribute = productAttribute;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
