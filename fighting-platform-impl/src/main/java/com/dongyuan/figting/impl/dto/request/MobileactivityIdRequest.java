package com.dongyuan.figting.impl.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.dongyuan.figting.impl.dto.BaseRequest;

public class MobileactivityIdRequest extends BaseRequest{
	@NotEmpty(message = "电话号码不能为空")
	private String mobile;
	
	@NotEmpty(message = "活动号不能为空")
	private String activityId;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

}
