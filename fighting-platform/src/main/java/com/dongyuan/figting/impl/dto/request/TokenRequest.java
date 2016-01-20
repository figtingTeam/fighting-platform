package com.dongyuan.figting.impl.dto.request;

public class TokenRequest {

	private String corpID;

	private String securityKey;

	public String getCorpID() {
		return corpID;
	}

	public void setCorpID(String corpID) {
		this.corpID = corpID;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

}
