package com.dongyuan.figting.impl.dto.response;

import java.util.Date;

public class TicketBasicInfoRes {

	// 认筹券号
	private String id;

	//认筹券类型 0:纸质券  1：电子券
	private int ticketType;
	
	//认筹券状态 
	private int ticketStatus;
	
	// 活动ID
	private long activityId;
	
	// 用户手机号
	private String mobile;

	// 活动名称
	private String activityName;

	// 活动开始时间
	private Date startTime;

	// 活动结束时间
	private Date endTime;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
