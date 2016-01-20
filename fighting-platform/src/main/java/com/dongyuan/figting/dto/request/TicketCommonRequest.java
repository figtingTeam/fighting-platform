package com.dongyuan.figting.dto.request;

import com.dongyuan.figting.dto.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

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
