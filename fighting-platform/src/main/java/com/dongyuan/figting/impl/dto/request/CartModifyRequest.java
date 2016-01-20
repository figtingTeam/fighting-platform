package com.dongyuan.figting.impl.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dongyuan.figting.impl.dto.BaseRequest;

public class CartModifyRequest extends BaseRequest {
	/**
	 * 购物车编码
	 */
	@NotNull(message = "购物车编码不能为空")
	private Long shoppingCartId;

	@NotNull(message = "活动ID不能为空")
	private Long activityId;

	/**
	 * 认筹券编码
	 */
	@NotBlank(message = "认筹券编码不能为空")
	private String ticketId;

	/**
	 * 商品数量
	 */
	@NotNull(message = "商品数量不能为空")
	@Min(value = 1, message = "最小购买数量不能为空")
	private Short count;

	/**
	 * 购物车最后更新时间
	 */
	@NotNull(message = "最后更新时间不能为空")
	private String updateTime;

	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public Short getCount() {
		return count;
	}

	public void setCount(Short count) {
		this.count = count;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

}
