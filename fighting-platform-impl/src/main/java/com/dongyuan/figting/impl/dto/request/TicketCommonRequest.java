package com.dongyuan.figting.impl.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.dongyuan.figting.impl.dto.BaseRequest;

public class TicketCommonRequest extends BaseRequest {

	@NotEmpty(message = "认筹券号不能为空")
	private String ticketId;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

}
