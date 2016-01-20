package com.midea.cmo2o.wx.impl.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.midea.cmo2o.wx.impl.dto.BaseRequest;

public class SmsCaptchaRequest extends BaseRequest{
	
	@NotEmpty(message = "手机号码不能为空")
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
