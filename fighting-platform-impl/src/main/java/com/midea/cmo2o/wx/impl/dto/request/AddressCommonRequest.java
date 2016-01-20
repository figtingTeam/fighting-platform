package com.midea.cmo2o.wx.impl.dto.request;

import javax.validation.constraints.NotNull;

import com.midea.cmo2o.wx.impl.dto.BaseRequest;

public class AddressCommonRequest extends BaseRequest {

	@NotNull(message = "地址ID为空")
	private Long addressId;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

}
