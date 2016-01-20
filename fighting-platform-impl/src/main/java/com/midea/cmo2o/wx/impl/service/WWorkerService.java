package com.midea.cmo2o.wx.impl.service;

import java.util.List;

import com.midea.cmo2o.wx.impl.dto.response.ActivityDataRes;




/**
 * 类IWxUserService.java的实现描述：微信用户接口
 * 
 * @author yj.ge 2015年12月29日 上午10:34:46
 * @email yj.ge@midea.com
 */
public interface WWorkerService {
	List <ActivityDataRes> getActivityListByWxCode(String wxCode,String mobile);
   
}
