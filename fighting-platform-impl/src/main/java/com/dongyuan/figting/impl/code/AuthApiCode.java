package com.dongyuan.figting.impl.code;

import java.util.Map;

public class AuthApiCode {

	/** 服务号cookie名称 **/
	public static final String CMO2O_WX_MP_TOKEN = "cmo2o_wx_mp_token";
	
	/** 企业号号cookie名称 **/
	public static final String CMO2O_WX_CP_TOKEN = "cmo2o_wx_cp_token";
	
	/** 授权成功**/
	public static final String AUTHORIZATION_SUCCESS = "1000";
	
	/** 未授权，请重新授权**/
	public static final String NO_AUTHORIZATION = "1001";
	
	/** 授权失败**/
	public static final String AUTHORIZATION_FAIL = "1002";

	public static void initResponseCode() {
		Map<String, String> enMsgMap = BaseApiCode.enMsgMap;
		Map<String, String> zhMsgMap = BaseApiCode.zhMsgMap;
		enMsgMap.put(NO_AUTHORIZATION, "auth.no_authorization");
		zhMsgMap.put(NO_AUTHORIZATION, "未授权，请重新授权");
		enMsgMap.put(AUTHORIZATION_FAIL, "auth.authorization_fail");
		zhMsgMap.put(AUTHORIZATION_FAIL, "授权失败");
	}
}
