package com.dongyuan.figting.impl.dto.request;

import javax.validation.constraints.NotNull;

import com.dongyuan.figting.impl.dto.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

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
