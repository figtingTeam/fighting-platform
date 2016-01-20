package com.dongyuan.figting.service.impl;

import com.dongyuan.figting.dto.response.WxUserInfo;
import com.dongyuan.figting.service.IWxUserService;
import com.dongyuan.figting.utils.FastJSONHelper;
import com.dongyuan.figting.utils.JedisUtil;
import org.springframework.stereotype.Service;

import com.dongyuan.figting.utils.StringUtil;

/**
 * 类WxUserServiceImpl.java的实现描述：微信用户信息服务类
 * 
 * @author huanghf 2016年1月2日 上午11:17:08
 * @email haifeng1.huang@midea.com
 */
@Service(value = "wxUserService")
public class WxUserServiceImpl implements IWxUserService {

	@Override
	public WxUserInfo getUserInfoByToken(String token) {
		String userStr = JedisUtil.getJedisInstance().execGetFromCache(token);
		if (!StringUtil.isBlank(userStr)) {
			return FastJSONHelper.deserialize(userStr, WxUserInfo.class);
		}
		return null;
	}

	@Override
	public String getOpenidByToken(String token) {
		return JedisUtil.getJedisInstance().execGetFromCache(token);
	}

}
