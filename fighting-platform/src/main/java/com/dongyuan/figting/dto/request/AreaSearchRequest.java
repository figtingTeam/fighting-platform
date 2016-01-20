package com.dongyuan.figting.dto.request;

import javax.validation.constraints.NotNull;

import com.dongyuan.figting.dto.BaseRequest;

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
