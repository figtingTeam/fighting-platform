package com.midea.cmo2o.wx.impl.dto.request;

import com.midea.cmo2o.wx.impl.dto.BaseRequest;

public class ActivityInfoRequest extends BaseRequest{
	
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
