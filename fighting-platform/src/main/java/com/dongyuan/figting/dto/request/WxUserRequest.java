package com.dongyuan.figting.dto.request;

import com.dongyuan.figting.dto.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

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
