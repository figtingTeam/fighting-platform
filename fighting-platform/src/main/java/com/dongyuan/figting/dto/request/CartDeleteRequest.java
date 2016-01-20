package com.dongyuan.figting.dto.request;

import javax.validation.constraints.NotNull;

import com.dongyuan.figting.dto.BaseRequest;
import org.hibernate.validator.constraints.NotBlank;

public class CartDeleteRequest extends BaseRequest {
	/**
	 * 购物车编码
	 */
	@NotNull(message = "购物车编码不能为空")
	private Long shoppingCartId;

	/**
	 * 认筹券编码
	 */
	@NotBlank(message = "认筹券编码不能为空")
	private String ticketId;

	@NotNull(message = "活动ID不能为空")
	private Long activityId;

	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

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

}
