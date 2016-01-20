package com.dongyuan.figting.impl.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * cookie工具类
 * @author wanghl
 */
public class CookieUtil {
	/**
	 *  读取cookie值
	 * @param request
	 * @param name cookie name
	 * @return Cookie对象
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null || name == null || name.length() == 0) {
			return null;
		}
		for (int i = 0; i < cookies.length; i++) {
			String key = cookies[i].getName().trim();
			if (StringUtils.equalsIgnoreCase(name, key)&&
					StringUtils.isNotBlank(cookies[i].getValue())) {
				return cookies[i];
			}
		}
		return null;
	}
	/**
	 * 删除cookie
	 * @param request
	 * @param response
	 * @param cookie
	 */
	public static void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			cookie.setPath(getPath(request));
			cookie.setValue("");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
	
	/**
	 * 删除cookie
	 * @param request
	 * @param response
	 * @param cookie
	 */
	public static void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, Cookie cookie, String path) {
		if (cookie != null) {
			cookie.setPath(path);
			cookie.setValue("");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
	/**
	 * 增加cookie
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String name, String value) {
		setCookie(request, response, name, value, 0x278d00);
	}
	/**
	 * 增加cookie到response中
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String name, String value, int maxAge) {
		setCookie(request, response, name, value, maxAge, getPath(request));
	}
	
	/**
	 * 增加cookie到response中
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 * @param path
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String name, String value, int maxAge, String path) {
		Cookie cookie = new Cookie(name, (value == null)?"" : value);
		cookie.setMaxAge(maxAge);
		cookie.setPath(path);
		response.setContentType("text/html;charset=utf-8");
		response.addCookie(cookie);
	}
	
	/**
	 * 增加cookie到response中
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 * @param path
	 * @param domain
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String name, String value, int maxAge, String path, String domain) {
		Cookie cookie = new Cookie(name, (value == null)?"" : value);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		cookie.setPath(path);
		response.setContentType("text/html;charset=utf-8");
		response.addCookie(cookie);
	}
	/**
	 * cookie存放路径
	 * @param request
	 * @return
	 */
	public static String getPath(HttpServletRequest request) {
		String path = request.getContextPath();
		return (StringUtils.isBlank(path)) ? "/" : path;
	}

}