package com.midea.cmo2o.wx.impl.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.midea.cmo2o.wx.impl.dto.BaseRequest;

public class WxUserRequest extends BaseRequest {

	@NotEmpty(message = "openid不能为空")
	private String openid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
