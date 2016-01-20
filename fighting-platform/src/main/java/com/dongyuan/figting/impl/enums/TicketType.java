package com.dongyuan.figting.impl.enums;

public enum TicketType {

	OFFLINE(0, "纸质券"), ONLINE(1, "电子券");

	private final int type;

	private final String name;

	TicketType(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public static TicketType valueOf(int type) {
		for (TicketType t : TicketType.values()) {
			if (t.getType() == type) {
				return t;
			}
		}
		return null;
	}
}
