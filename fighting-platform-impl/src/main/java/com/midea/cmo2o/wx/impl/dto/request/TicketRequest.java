package com.midea.cmo2o.wx.impl.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.midea.cmo2o.wx.impl.dto.BaseRequest;

public class TicketRequest extends BaseRequest {

	@NotEmpty(message = "认筹券号不能为空")
	private String ticketId;
	
	@NotNull(message = "活动ID不能为空")
	private Long activityId;

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
