package com.dongyuan.figting.service;

import com.dongyuan.figting.dto.request.UserRegisterReq;

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
	 * @param userRegisteReq
	 * @return 错误码
	 */
	String register(UserRegisterReq userRegisterReq);
}
