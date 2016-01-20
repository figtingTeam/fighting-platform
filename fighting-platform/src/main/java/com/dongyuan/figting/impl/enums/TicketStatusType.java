package com.dongyuan.figting.impl.enums;

public enum TicketStatusType {

	ONGOING(1, "正在进行"), 
	NOT_STARTED(2, "相关联的活动未开始"),
	OUTDATED(-1, "活动已过期"),
	DISABLED(-2, "已禁用"),
	ACTIVITY_DISABLED(-3, "活动已被禁用"),
	REFUNDED(-4, "已退款");

	private final int type;

	private final String name;

	TicketStatusType(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public static TicketStatusType valueOf(int type) {
		for (TicketStatusType t : TicketStatusType.values()) {
			if (t.getType() == type) {
				return t;
			}
		}
		return null;
	}
}
