package com.dongyuan.figting.controller;

import com.dongyuan.figting.code.BaseApiCode;
import com.dongyuan.figting.core.excute.ControllerWrapper;
import com.dongyuan.figting.core.excute.CtrlRespPackUtil;
import com.dongyuan.figting.dto.BodyData;
import com.dongyuan.figting.dto.request.UserRegisterReq;
import com.dongyuan.figting.service.UserService;
import com.dongyuan.figting.utils.FastJSONHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述： 用户信息控制层
 *
 * @author huanghf
 * @email 736943550@qq.com
 * @date 2016年01月21日 10:11
 * @copyright 美的电子商务有限公司
 */

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 *
	 * @param userRegisterReq
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody
	BodyData getAreas(final @RequestBody UserRegisterReq userRegisterReq) {
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(userRegisterReq, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				String resuleCode = userService.register(userRegisterReq);
				if (BaseApiCode.OPERATE_SUCCESS.equals(resuleCode)) {
					response.setContent(true);
					LOGGER.info("注册用户成功，用户信息如下：{}", FastJSONHelper.serialize(userRegisterReq));
					return BaseApiCode.OPERATE_SUCCESS;
				}
				response.setContent(false);
				LOGGER.info("注册用户失败，失败原因如下：{}", BaseApiCode.getZhMsg(resuleCode));
				return resuleCode;
			}
		});
	}

	public static void main(String[] args) {
		UserRegisterReq userRegisterReq = new UserRegisterReq();
		userRegisterReq.setNickName("hhf");
		userRegisterReq.setPhone("13951657704");
		userRegisterReq.setPassword("123");

		System.out.println(FastJSONHelper.serialize(userRegisterReq));
	}
}