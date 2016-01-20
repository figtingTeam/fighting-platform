package com.dongyuan.figting.dto.request;


import com.dongyuan.figting.dto.BaseRequest;

public class ActivityListRequest extends BaseRequest {

	private String wxCode;
	
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWxCode() {
		return wxCode;
	}

	public void setWxCode(String wxCode) {
		this.wxCode = wxCode;
	}
	
}
