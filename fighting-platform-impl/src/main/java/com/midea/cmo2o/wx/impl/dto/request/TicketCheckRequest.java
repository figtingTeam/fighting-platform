package com.midea.cmo2o.wx.impl.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

public class TicketCheckRequest extends WxUserRequest {

	@NotEmpty(message = "认筹券号不能为空")
	private String ticketId;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

}
