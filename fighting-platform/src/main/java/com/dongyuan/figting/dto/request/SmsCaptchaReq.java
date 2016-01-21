package com.dongyuan.figting.dto.request;

import com.dongyuan.figting.dto.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;


public class SmsCaptchaReq extends BaseRequest {
	
	@NotEmpty(message = "手机号码不能为空")
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
