package com.dongyuan.figting.dto.request;

import javax.validation.constraints.NotNull;

import com.dongyuan.figting.dto.BaseRequest;

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
