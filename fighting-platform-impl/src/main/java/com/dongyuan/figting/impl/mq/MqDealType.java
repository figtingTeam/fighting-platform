package com.dongyuan.figting.impl.mq;

/**
 * 
* @ClassName: MqDealType 
* @Description: MQ消息处理类 
* @author 汪海霖   wanghl15@midea.com.cn
* @date 2015-7-9 下午4:53:14
 */

public enum MqDealType {
	
	SERVICE_REQUEST_STATUS("wx-msg","saleOrderMsgHandler","订单状态通知");
	
	private String mqTag;

	private String beanName;
	
	private String mqName;
	
	private MqDealType(String mqTag,String beanName,String mqName){
		this.mqTag = mqTag;
		this.beanName = beanName;
		this.mqName = mqName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMqName() {
		return mqName;
	}

	public void setMqName(String mqName) {
		this.mqName = mqName;
	}

	public String getMqTag() {
		return mqTag;
	}

	public void setMqTag(String mqTag) {
		this.mqTag = mqTag;
	}
	
	public static MqDealType getMqDealTypeByTag(String mqTag){
		for(MqDealType type : MqDealType.values()){
			if(type.getMqTag().equals(mqTag)){
				return type;
			}
		}
		return null;
	}
}
