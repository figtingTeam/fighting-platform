package com.midea.cmo2o.wx.impl.service.impl;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midea.cmo2o.wx.impl.code.BaseApiCode;
import com.midea.cmo2o.wx.impl.code.TicketApiCode;
import com.midea.cmo2o.wx.impl.service.ISmsService;
import com.midea.cmo2o.wx.impl.utils.CacheKeyRegistry;
import com.midea.cmo2o.wx.impl.utils.CaptchaUtils;
import com.midea.cmo2o.wx.impl.utils.JedisUtil;
import com.midea.cmo2o.wx.impl.utils.StringUtil;
import com.midea.trade.dmz.api.rpc.hessian.ICommonServiceHessian;

/**
 * 类SmsServiceImpl.java的实现描述：短信服务接口
 * 
 * @author huanghf 2015年12月28日 下午8:44:20
 * @email haifeng1.huang@midea.com
 */
@Service(value = "smsService")
public class SmsServiceImpl implements ISmsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SmsServiceImpl.class);

	private static final String SMS_MSG = "您的验证码{0}，请在15分钟内完成验证；为保障账号安全，请勿转发验证码给他人。";

	@Autowired
	private ICommonServiceHessian smsServiceClient;

	@Override
	public String sendCaptcha(String mobile) {
		if (StringUtil.isBlank(mobile)) {
			return TicketApiCode.BLANK_MOBILE;
		}
		boolean successFlag = false;
		// 生成验证码
		String captcha = CaptchaUtils.getCaptcha();
		LOGGER.info("获取验证码{}，发至手机号{}.", captcha, mobile);
		String content = MessageFormat.format(SMS_MSG, captcha);
		for (int sendTimes = 1; sendTimes <= 3; sendTimes++) {
			boolean[] sendFlag = smsServiceClient.sendSms(new String[] { mobile }, content);
			if (sendFlag[0]) {
				successFlag = true;
				break;
			} else {
				LOGGER.info("发送验证码失败，进行重发!当前发送次数:{}", sendTimes);
			}
		}
		// 发送成功
		if (successFlag) {
			LOGGER.info("成功向手机号：{}发送验证码：{}", mobile, captcha);
			// redis中存活15分钟
			JedisUtil.getJedisInstance().execSetexToCache(
					CacheKeyRegistry.getMobileCaptchaCacheKey(mobile), 15 * 60, captcha);
			return BaseApiCode.OPERATE_SUCCESS;
		}
		LOGGER.info("获取验证码失败", mobile, captcha);
		return TicketApiCode.GET_CAPTCHA_FAIL;
	}

}
