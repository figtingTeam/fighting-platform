package com.dongyuan.figting.impl.service;

/**
 * 类ISmsService.java的实现描述：短信服务接口
 * 
 * @author huanghf 2015年12月24日 下午5:34:46
 * @email haifeng1.huang@midea.com
 */
public interface ISmsService {

	/**
	 * 发送短信验证码
	 * @param mobile
	 * @return
	 */
	String sendCaptcha(String mobile);
}
