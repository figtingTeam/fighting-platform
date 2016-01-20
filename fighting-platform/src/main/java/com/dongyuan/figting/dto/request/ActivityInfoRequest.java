package com.dongyuan.figting.dto.request;

import com.dongyuan.figting.dto.BaseRequest;

public class ActivityInfoRequest extends BaseRequest {
	
	private String ticketId;
	
	private String mobile;
	
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
