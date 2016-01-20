package com.dongyuan.figting.impl.dto.response;

import com.dongyuan.figting.impl.entity.MArea;

public class AreaRes extends MArea {

	private boolean hasSubArea;

	public boolean isHasSubArea() {
		return hasSubArea;
	}

	public void setHasSubArea(boolean hasSubArea) {
		this.hasSubArea = hasSubArea;
	}

}
