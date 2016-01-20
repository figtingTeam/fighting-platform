package com.midea.cmo2o.wx.impl.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

public class TicketBindRequest extends TicketCheckRequest {

	@NotEmpty(message = "验证码不能为空")
	private String captcha;

	@NotEmpty(message = "手机不能为空")
	private String mobile;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
