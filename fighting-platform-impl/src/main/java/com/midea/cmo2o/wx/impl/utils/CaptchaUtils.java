package com.midea.cmo2o.wx.impl.utils;

import java.util.Random;

public class CaptchaUtils {
	private final static int captchaLength = 6;
	private final static String randString = "12345678920";
	
	/**
	 * 
	 * @return 获取6位随机数字
	 */
	public static String getCaptcha() {
		Random random = new Random();
		StringBuilder captcha = new StringBuilder();
		for (int i = 0; i < captchaLength; i++) {
			captcha.append(randString.charAt(random.nextInt(10)));
		}
		return captcha.toString();
	}
}
