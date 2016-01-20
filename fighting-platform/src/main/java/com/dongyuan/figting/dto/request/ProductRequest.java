package com.dongyuan.figting.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dongyuan.figting.dto.BaseRequest;

public class ProductRequest extends BaseRequest {

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

}
