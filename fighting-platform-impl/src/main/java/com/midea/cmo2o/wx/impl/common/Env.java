package com.midea.cmo2o.wx.impl.common;

public class Env {

	public static final String ENV_LOCAL = "local";

	public static final String ENV_DEV = "dev";

	public static final String ENV_BETA = "beta";

	public static final String ENV_PROD = "prod";

	private static String sign = null;

	private String ownSign;
	
	public Env() {
	}

	public void init() {
		if (sign == null)
			sign = getOwnSign();
	}


	public String getOwnSign() {
		return ownSign;
	}

	public void setOwnSign(String ownSign) {
		this.ownSign = ownSign;
	}

	public static String getSign() {
		return sign;
	}
}
