package com.dongyuan.figting.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.dongyuan.figting.dto.BaseRequest;
import org.hibernate.validator.constraints.NotBlank;

public class CartAddRequest extends BaseRequest {

	/**
	 * 认筹券编码
	 */
	@NotBlank(message = "认筹券号不能为空")
	private String ticketId;

	/**
	 * 活动编码
	 */
	@NotNull(message = "活动编码不能为空")
	private Long activityId;

	/**
	 * 商品短码
	 */
	@NotBlank(message = "商品短码不能为空")
	private String shortCode;

	/**
	 * 商品特性（特价机，常规机）
	 */
	@NotNull(message = "商品特性不能为空")
	private Byte productAttr;

	/**
	 * 购买数量
	 */
	@NotNull(message = "商品数量不能为空")
	@Min(value = 1, message = "最小购买数量大于零")
	private Short count;

	/**
	 * 导购员编码
	 */
	private Long salesmanId;

	/**
	 * 购物商品来源(服务号，企业号)
	 */
	@NotBlank(message = "购物商品来源不能为空")
	private String tradeFrom;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

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

	public Byte getProductAttr() {
		return productAttr;
	}

	public void setProductAttr(Byte productAttr) {
		this.productAttr = productAttr;
	}

	public Short getCount() {
		return count;
	}

	public void setCount(Short count) {
		this.count = count;
	}

	public Long getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Long salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getTradeFrom() {
		return tradeFrom;
	}

	public void setTradeFrom(String tradeFrom) {
		this.tradeFrom = tradeFrom;
	}

}
