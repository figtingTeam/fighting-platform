package com.dongyuan.figting.dto.response;

import com.midea.cmo2o.ticket.api.dto.ActivityData;

public class ActivityDataRes extends ActivityData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long workId;

	public Long getWorkId() {
		return workId;
	}

	public void setWorkId(Long workId) {
		this.workId = workId;
	}

}
