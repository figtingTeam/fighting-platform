package com.dongyuan.figting.impl.interceptors;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongyuan.figting.impl.code.AuthApiCode;
import com.dongyuan.figting.impl.code.BaseApiCode;
import com.dongyuan.figting.impl.dto.BodyData;
import com.dongyuan.figting.impl.dto.ResponseError;
import com.dongyuan.figting.impl.enums.TradeFromType;
import com.dongyuan.figting.impl.utils.FastJSONHelper;
import com.dongyuan.figting.impl.utils.JedisUtil;
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

	// 会话时长
	private String defaultAvailableTime;

	@Value("${cmo2o.domainsScope}")
	private String domainsScope;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	public void setDefaultAvailableTime(String defaultAvailableTime) {
		this.defaultAvailableTime = defaultAvailableTime;
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
		String requestFrom = request.getParameter("requestFrom");
		if (TradeFromType.CP.toString().equalsIgnoreCase(requestFrom)) {
			LOGGER.info("请求url:{},来自企业号...", requestUrl);
			// mock数据 ----------start-------------------------
			/*CookieUtil.setCookie(request, response, AuthApiCode.CMO2O_WX_CP_TOKEN,
					"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba", -1, "/");
			int sessionAvailableTime_ = Integer.parseInt(defaultAvailableTime) * 60;
			JedisUtil.getJedisInstance().execSetexToCache(
					"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba",
					sessionAvailableTime_,
					"{\"mobile\":\"13951657704\",\"userId\":\"oFuguuFcIx0Kby\",\"weiXinId\":\"hhf_gyj\"}");*/
					// mock数据----------end-------------------------

			// 判断请求cookie 所带的cmo2o_wx_mp_token是否还有效
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (AuthApiCode.CMO2O_WX_CP_TOKEN.equals(cookie.getName())) {
						String tokenValue = cookie.getValue();
						Boolean tokenExist =
								JedisUtil.getJedisInstance().execExistsFromCache(tokenValue);
						if (tokenExist != null && tokenExist.booleanValue()) {
							int sessionAvailableTime = Integer.parseInt(defaultAvailableTime) * 60;
							JedisUtil.getJedisInstance().execExpireToCache(tokenValue,
									sessionAvailableTime);
							sessionAvailable = true;
							LOGGER.info("会话有效...");
							break;
						}
					}
				}
			}
		} else if(TradeFromType.MP.toString().equalsIgnoreCase(requestFrom)){
			LOGGER.info("请求url:{},来自服务号...", requestUrl);
			// mock数据 ----------start-------------------------
			/*CookieUtil.setCookie(request, response, AuthApiCode.CMO2O_WX_MP_TOKEN,
					"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba", -1, "/");
			int sessionAvailableTime_ = Integer.parseInt(defaultAvailableTime) * 60;
			JedisUtil.getJedisInstance().execSetexToCache(
					"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba",
					sessionAvailableTime_, "oNDIwwXKCN6PJxgO4-d9zmO_lV1Q");*/
			// mock数据----------end-------------------------

			// 判断请求cookie 所带的cmo2o_wx_mp_token是否还有效
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (AuthApiCode.CMO2O_WX_MP_TOKEN.equals(cookie.getName())) {
						String tokenValue = cookie.getValue();
						Boolean tokenExist =
								JedisUtil.getJedisInstance().execExistsFromCache(tokenValue);
						// 心跳
						if (tokenExist != null && tokenExist.booleanValue()) {
							int sessionAvailableTime = Integer.parseInt(defaultAvailableTime) * 60;
							JedisUtil.getJedisInstance().execExpireToCache(tokenValue,
									sessionAvailableTime);
							sessionAvailable = true;
							LOGGER.info("会话有效...");
							break;
						}
					}
				}
			}
		}

		if (!sessionAvailable) {
			// 会话失效
			LOGGER.info("会话无效，请重新授权...");
			ResponseError errorMsg = new ResponseError();
			errorMsg.setErrCode(AuthApiCode.NO_AUTHORIZATION);
			errorMsg.setZhMsg(BaseApiCode.getZhMsg(AuthApiCode.NO_AUTHORIZATION));
			PrintWriter out = response.getWriter();
			out.print(FastJSONHelper.serialize(BodyData.make(true, errorMsg)));
			out.flush();
		}
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