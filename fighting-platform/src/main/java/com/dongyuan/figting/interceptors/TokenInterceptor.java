package com.dongyuan.figting.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类MpTokenInterceptor.java的实现描述：来自服务号的请求拦截器
 * 
 * @author huanghf 2015年11月24日 上午11:04:52
 * @email haifeng1.huang@midea.com
 */
public class TokenInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenInterceptor.class);

	// 请求url白名单
	public String[] allowUrls;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	/**
	 * 检查会话是否过期
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// 强制页面不缓存响应
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
		if (!ArrayUtils.isEmpty(allowUrls)) {
			for (String url : allowUrls) {
				if (requestUrl.contains(url)) {
					return true;
				}
			}
		}
		boolean sessionAvailable = false;
		return sessionAvailable;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception e) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object handler,
			ModelAndView arg3) throws Exception {
	}
}