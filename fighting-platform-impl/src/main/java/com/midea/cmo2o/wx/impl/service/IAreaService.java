package com.midea.cmo2o.wx.impl.service;

import java.util.List;

import com.midea.cmo2o.wx.impl.dto.response.AreaRes;

/**
 * 地区信息服务
 *
 */
public interface IAreaService {
	
	/**
	 * 获取地区列表
	 * 
	 * @return
	 */
	List<AreaRes> getAreas(Integer parentCode);
}
