package com.midea.cmo2o.wx.impl.dto.request;

import javax.validation.constraints.NotNull;

import com.midea.cmo2o.wx.impl.dto.BaseRequest;

public class AreaSearchRequest extends BaseRequest {

	@NotNull(message = "地址父编码不能为空")
	private Integer parentCode;

	public Integer getParentCode() {
		return parentCode;
	}

	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}

}
