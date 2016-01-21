package com.dongyuan.figting.code;

import java.util.Map;

/**
 * 描述： 用户相关信息错误码
 *
 * @author huanghf
 * @email haifeng1.huang@midea.com
 * @date 2016年01月21日 10:35
 * @copyright 美的电子商务有限公司
 */
public class UserApiCode extends BaseApiCode{
	
	/** 注册用户失败**/
	public static final String REGISTER_FAIL = "1001";

	public static void initResponseCode() {
		Map<String, String> enMsgMap = BaseApiCode.enMsgMap;
		Map<String, String> zhMsgMap = BaseApiCode.zhMsgMap;
		enMsgMap.put(REGISTER_FAIL, "user.register_fail");
		zhMsgMap.put(REGISTER_FAIL, "注册用户失败");
	}
}
