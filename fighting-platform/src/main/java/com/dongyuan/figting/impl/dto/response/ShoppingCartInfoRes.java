package com.dongyuan.figting.impl.dto.response;

import com.midea.cmo2o.shopping.api.domain.ShoppingCartInfo;

public class ShoppingCartInfoRes {

	private AddressInfoRes address;

	private ShoppingCartInfo shoppingCartInfo;

	public AddressInfoRes getAddress() {
		return address;
	}

	public void setAddress(AddressInfoRes address) {
		this.address = address;
	}

	public ShoppingCartInfo getShoppingCartInfo() {
		return shoppingCartInfo;
	}

	public void setShoppingCartInfo(ShoppingCartInfo shoppingCartInfo) {
		this.shoppingCartInfo = shoppingCartInfo;
	}

}
