package com.dongyuan.figting.dto.response;

import java.util.Date;

public class ActivityInfoRes {

	// 认筹券号
	private String ticketId;

	// 认筹券类型
	private int ticketType;

	// 认筹券状态
	private int ticketStatus;

	// 活动ID
	private long activityId;

	// 用户姓名
	private String name;

	// 用户手机号
	private String mobile;

	// 购物车SKU数量
	private int cartAmount;

	// 是否已签到
	private boolean isCheckin;

	// 是否已领赠
	private boolean isGift;

	// 活动名称
	private String activityName;

	// 活动地点
	private String address;

	// 活动开始时间
	private Date startTime;

	// 活动结束时间
	private Date endTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}

	public boolean isCheckin() {
		return isCheckin;
	}

	public void setCheckin(boolean isCheckin) {
		this.isCheckin = isCheckin;
	}

	public boolean isGift() {
		return isGift;
	}

	public void setGift(boolean isGift) {
		this.isGift = isGift;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getTicketType() {
		return ticketType;
	}

	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}

	public int getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

}
