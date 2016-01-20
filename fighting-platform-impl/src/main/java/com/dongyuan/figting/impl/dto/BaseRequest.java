package com.dongyuan.figting.impl.dto;

import com.dongyuan.figting.impl.dto.utlil.ApiParamCheckUtil;

public class BaseRequest {
	
	public String check(){
		return ApiParamCheckUtil.checkParam(this);
	}
	
}
