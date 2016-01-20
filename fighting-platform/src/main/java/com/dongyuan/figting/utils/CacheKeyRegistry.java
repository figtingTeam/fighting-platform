package com.dongyuan.figting.utils;

import com.dongyuan.figting.code.AuthApiCode;

/**
 * 类CacheKeyRegistry.java的实现描述：缓存key生成规则
 * 
 * @author huanghf 2016年1月11日 下午2:02:18
 * @email haifeng1.huang@midea.com
 */
public class CacheKeyRegistry {

	private static final String WX_OPENID = "cmo2o:wx-cache:" + AuthApiCode.CMO2O_WX_MP_TOKEN + "_";

	private static final String WX_WEIXINID =
			"cmo2o:wx-cache:" + AuthApiCode.CMO2O_WX_CP_TOKEN + "_";

	private static final String WX_AREA_KEY = "cmo2oweb:areaKey:getAreaByCode_";

	private static final String WX_AREA_DETAIL_KEY = "cmo2o:wx-cache:getAreaDetailByCode_";

	private static final String MOBILE_CAPTCHA = "cmo2o:wx-cache:mobile_captcha_";

	public static final String getWxOpenidForCacheKey(String uuid) {
		StringBuilder sb = new StringBuilder();
		sb.append(WX_OPENID).append(uuid);
		return sb.toString();
	}

	public static final String getWxIdForCacheKey(String uuid) {
		StringBuilder sb = new StringBuilder();
		sb.append(WX_WEIXINID).append(uuid);
		return sb.toString();
	}

	public static final String getMobileCaptchaCacheKey(String mobile) {
		StringBuilder sb = new StringBuilder();
		sb.append(MOBILE_CAPTCHA).append(mobile);
		return sb.toString();
	}

	public static final String getAreaCacheKey(String code) {
		StringBuilder sb = new StringBuilder();
		sb.append(WX_AREA_KEY).append(code);
		return sb.toString();
	}

	public static final String getAreaDetailCacheKey(String code) {
		StringBuilder sb = new StringBuilder();
		sb.append(WX_AREA_DETAIL_KEY).append(code);
		return sb.toString();
	}
}
