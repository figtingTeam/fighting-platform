package com.dongyuan.figting.impl.enums;

public enum WxChannel {

	MIDEA_AIR_CONDITIONER("air_conditioner", "美的空调服务号");

	private final String channel;
	
	private final String channelName;

	WxChannel(String channel, String channelName) {
		this.channel = channel;
		this.channelName = channelName;
	}

	public String getChannelName() {
		return channelName;
	}

	public String getChannel() {
		return channel;
	}
}
