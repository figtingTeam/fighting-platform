package com.midea.cmo2o.wx.impl.dto.response;

import com.midea.cmo2o.wx.impl.entity.MArea;

public class AreaRes extends MArea {

	private boolean hasSubArea;

	public boolean isHasSubArea() {
		return hasSubArea;
	}

	public void setHasSubArea(boolean hasSubArea) {
		this.hasSubArea = hasSubArea;
	}

}
