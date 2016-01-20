package com.dongyuan.figting.dto;

public class ResponseError{
	/**
	 * 错误编码
	 */
	private String errCode;
	/**
	 * 错误中文描述
	 */
	private String zhMsg;
	/**
	 * 错误英文描述
	 */
	private String enMsg;
	/**
	 * 错误详细描述
	 */
	private String zhDetailMsg;
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getZhMsg() {
		return zhMsg;
	}
	public void setZhMsg(String zhMsg) {
		this.zhMsg = zhMsg;
	}
	public String getEnMsg() {
		return enMsg;
	}
	public void setEnMsg(String enMsg) {
		this.enMsg = enMsg;
	}
	public String getZhDetailMsg() {
		return zhDetailMsg;
	}
	public void setZhDetailMsg(String zhDetailMsg) {
		this.zhDetailMsg = zhDetailMsg;
	}
	
	

}
