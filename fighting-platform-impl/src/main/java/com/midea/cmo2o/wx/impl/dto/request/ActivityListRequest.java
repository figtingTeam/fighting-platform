package com.midea.cmo2o.wx.impl.dto.request;


import com.midea.cmo2o.wx.impl.dto.BaseRequest;

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
