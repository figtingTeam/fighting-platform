package com.dongyuan.figting.impl.utils;

public class HttpServletRequestUtils {

	/**
	 * 在负载均衡 + 集群环境中 获取 客户端 IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteIP(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
}