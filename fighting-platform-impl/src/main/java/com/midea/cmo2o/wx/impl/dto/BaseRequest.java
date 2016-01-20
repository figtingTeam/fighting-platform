package com.midea.cmo2o.wx.impl.dto;

import com.midea.cmo2o.wx.impl.dto.utlil.ApiParamCheckUtil;

public class BaseRequest {
	
	public String check(){
		return ApiParamCheckUtil.checkParam(this);
	}
	
}
