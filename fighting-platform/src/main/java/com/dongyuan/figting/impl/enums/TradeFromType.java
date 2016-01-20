package com.dongyuan.figting.impl.enums;

public enum TradeFromType {

	MP("服务号"), CP("企业号");

	private final String name;

	TradeFromType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
