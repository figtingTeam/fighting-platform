package com.dongyuan.figting.impl.service;

import com.dongyuan.figting.impl.dto.response.WxUserInfo;

/**
 * 类IWxUserService.java的实现描述：微信用户信息获取接口
 * 
 * @author huanghf 2015年12月24日 下午5:34:46
 * @email haifeng1.huang@midea.com
 */
public interface IWxUserService {

	/**
	 * 根据cookie值获取openid
	 * @param token
	 * @return
	 */
	String getOpenidByToken(String token);

	/**
	 * 根据cookie值获取企业号用户信息
	 * @param token
	 * @return
	 */
	WxUserInfo getUserInfoByToken(String token);

}
