package com.dongyuan.figting.dto;

import com.dongyuan.figting.dto.utlil.ApiParamCheckUtil;

public class BaseRequest {
	
	public String check(){
		return ApiParamCheckUtil.checkParam(this);
	}
	
}
