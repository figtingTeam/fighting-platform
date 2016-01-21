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
public class UserApiCode extends BaseApiCode {

	/**
	 * 注册用户失败
	 **/
	public static final String REGISTER_FAIL = "1001";

	/**
	 * 手机号不能为空
	 **/
	public static final String BLANK_MOBILE = "1002";

	/**
	 * 获取验证码失败
	 */
	public static final String GET_CAPTCHA_FAIL = "1003";

	public static void initResponseCode() {
		Map<String, String> enMsgMap = BaseApiCode.enMsgMap;
		Map<String, String> zhMsgMap = BaseApiCode.zhMsgMap;
		enMsgMap.put(REGISTER_FAIL, "user.register_fail");
		zhMsgMap.put(REGISTER_FAIL, "注册用户失败");
		enMsgMap.put(BLANK_MOBILE, "user.blank_mobile");
		zhMsgMap.put(BLANK_MOBILE, "手机号不能为空");
		enMsgMap.put(GET_CAPTCHA_FAIL, "user.get_captcha_fail");
		zhMsgMap.put(GET_CAPTCHA_FAIL, "获取验证码失败");
	}
}
