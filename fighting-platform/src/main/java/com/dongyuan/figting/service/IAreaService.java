package com.dongyuan.figting.service;

import java.util.List;

import com.dongyuan.figting.dto.response.AreaRes;

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
