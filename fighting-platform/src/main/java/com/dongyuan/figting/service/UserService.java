package com.dongyuan.figting.service;

import com.dongyuan.figting.dto.request.UserRegisterReq;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述： 用户信息业务层
 *
 * @author huanghf
 * @email haifeng1.huang@midea.com
 * @date 2016年01月21日 10:15
 * @copyright 美的电子商务有限公司
 */
public interface UserService {

	/**
	 * 用户注册
	 * @param userRegisterReq
	 * @return 错误码
	 */
	String register(UserRegisterReq userRegisterReq);

	/**
	 * 发送短信验证码
	 * @param mobile
	 * @return
	 */
	String sendCaptcha(String mobile, HttpServletRequest req);
}
