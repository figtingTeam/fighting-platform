package com.dongyuan.figting.impl.dto.request;

import javax.validation.constraints.NotNull;

import com.dongyuan.figting.impl.dto.BaseRequest;

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
