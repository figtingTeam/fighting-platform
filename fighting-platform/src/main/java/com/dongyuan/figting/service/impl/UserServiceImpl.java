package com.dongyuan.figting.service.impl;

import com.dongyuan.figting.code.BaseApiCode;
import com.dongyuan.figting.code.UserApiCode;
import com.dongyuan.figting.dao.FUserMapper;
import com.dongyuan.figting.dto.request.UserRegisterReq;
import com.dongyuan.figting.entity.FUser;
import com.dongyuan.figting.service.UserService;
import com.dongyuan.figting.utils.CaptchaUtils;
import com.dongyuan.figting.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.Date;

/**
 * 描述： 用户信息业务实现层
 *
 * @author huanghf
 * @email haifeng1.huang@midea.com
 * @date 2016年01月21日 10:22
 * @copyright 美的电子商务有限公司
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private SmsServiceClient smsServiceClient;

	@Autowired
	private FUserMapper fUserMapper;

	private final static String smsTemplateId = "1";

	@Override
	public String register(UserRegisterReq userRegisterReq, HttpServletRequest req) {
		String captcha = (String) req.getSession().getAttribute(getSessionKey(userRegisterReq.getMobile()));
		if (StringUtil.isBlank(captcha)) {
			LOGGER.info("验证码{}过期.", userRegisterReq.getCaptcha());
			return UserApiCode.CAPTCHA_EXPIRE;
		}
		if (!captcha.equals(userRegisterReq.getCaptcha())) {
			LOGGER.info("验证码{}错误.", userRegisterReq.getCaptcha());
			return UserApiCode.CAPTCHA_ERROR;
		}
		FUser fUser = new FUser();
		fUser.setNickname(userRegisterReq.getNickName());
		fUser.setPhone(userRegisterReq.getMobile());
		fUser.setPassword(userRegisterReq.getPassword());
		fUser.setEnabled(Boolean.TRUE);
		fUser.setCreatetime(new Date());
		int i = fUserMapper.insert(fUser);
		if (i == 1)
			return BaseApiCode.OPERATE_SUCCESS;
		return UserApiCode.REGISTER_FAIL;
	}

	@Override
	public String sendCaptcha(String mobile, HttpServletRequest req) {
		if (StringUtil.isBlank(mobile)) {
			return UserApiCode.BLANK_MOBILE;
		}
		boolean successFlag = false;
		// 生成验证码
		String captcha = CaptchaUtils.getCaptcha();
		LOGGER.info("获取验证码{}，发至手机号{}.", captcha, mobile);
		for (int sendTimes = 1; sendTimes <= 3; sendTimes++) {
			boolean sendFlag = smsServiceClient.sendTemplateSMS(mobile, smsTemplateId, new String[]{captcha});
			if (sendFlag) {
				successFlag = true;
				break;
			} else {
				LOGGER.info("发送验证码失败，进行重发!当前发送次数:{}", sendTimes);
			}
		}
		// 发送成功
		if (successFlag) {
			LOGGER.info("成功向手机号：{}发送验证码：{}", mobile, captcha);
			//验证码存到session
			HttpSession session = req.getSession();
			session.setAttribute(getSessionKey(mobile), captcha);
			session.setMaxInactiveInterval(15 * 60);
			return BaseApiCode.OPERATE_SUCCESS;
		}
		LOGGER.info("{}获取验证码{}失败", mobile, captcha);
		return UserApiCode.GET_CAPTCHA_FAIL;
	}

	private String getSessionKey(String mobile) {
		return "captcha_" + mobile;
	}
}
