package com.midea.cmo2o.wx.impl.enums;

public enum WxChannel {

	MIDEA_AIR_CONDITIONER("air_conditioner", "美的空调服务号");

	private final String channel;
	
	private final String channelName;

	private WxChannel(String channel, String channelName) {
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
