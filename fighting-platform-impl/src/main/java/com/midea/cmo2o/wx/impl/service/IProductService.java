package com.midea.cmo2o.wx.impl.service;

import java.util.Map;

/**
 * 
 * 类IProductService.java的实现描述：商品服务接口
 * @author huanghf 2015年12月28日 下午6:52:00
 * @email  haifeng1.huang@midea.com
 */
public interface IProductService {
	
	/**
	 * 根据活动ID、商品短码查找商品信息
	 * @param activityId
	 * @param shortCode
	 * @return
	 */
	Map<String, Object> getProductInfo(Long activityId, String shortCode);
}
