package com.dongyuan.figting.impl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongyuan.figting.impl.code.AuthApiCode;
import com.dongyuan.figting.impl.code.BaseApiCode;
import com.dongyuan.figting.impl.common.Env;
import com.dongyuan.figting.impl.dto.BodyData;
import com.dongyuan.figting.impl.dto.ResponseError;
import com.dongyuan.figting.impl.dto.request.TokenRequest;
import com.dongyuan.figting.impl.dto.response.WxUserInfo;
import com.dongyuan.figting.impl.enums.TradeFromType;
import com.dongyuan.figting.impl.utils.*;
import com.dongyuan.figting.impl.utils.httpclient.SimplePostRequestExecutor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dongyuan.figting.impl.utils.CacheKeyRegistry;
import com.dongyuan.figting.impl.utils.CookieUtil;
import com.dongyuan.figting.impl.utils.JedisUtil;
import com.dongyuan.figting.impl.utils.StringUtil;
import com.dongyuan.figting.impl.utils.UUIDUtils;
import com.dongyuan.figting.impl.utils.httpclient.SimpleGetRequestExecutor;
import com.midea.trade.common.util.FastJSONHelper;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpUser;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

/**
 * 类OAuthController.java的实现描述：授权URL
 * 
 * @author huanghf 2015年12月26日 下午1:41:19
 * @email haifeng1.huang@midea.com
 */
@Controller
public class OauthController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OauthController.class);

	@Value("${session.defaultAvailableTime}")
	private String defaultAvailableTime;

	@Value("${cmo2o.domainsScope}")
	private String domainsScope;

	@Value("${cmo2o.prod.corpID}")
	private String corpID;

	@Value("${cmo2o.prod.securityKey}")
	private String securityKey;

	@Autowired
	private WxMpService wxMpService;

	@Autowired
	private WxCpService wxCpService;

	private static CloseableHttpClient httpClient = HttpClients.createDefault();

	@RequestMapping(value = "/authorize", method = RequestMethod.GET)
	public @ResponseBody
	BodyData authorizeMp(HttpServletRequest request,
			HttpServletResponse response) {
		boolean sessionAvailable = false;
		String code = request.getParameter("code");
		String requestFrom = request.getParameter("requestFrom");
		LOGGER.info("code:{},from:{}", code, requestFrom);
		if (!StringUtil.isBlank(code)) {
			// 测试用
			if ("000000000000".equals(code)) {
				if (TradeFromType.MP.toString().equalsIgnoreCase(requestFrom)) {
					LOGGER.info("000000000000进入微信服务号授权通道.");
					String openid = "oFuguuFcIx0Kbyt3degQlBt5cZJc";
					// 将 openid存入Redis，默认有效时间为 sessionAvailableTime
					// 120分钟
					int sessionAvailableTime = Integer.parseInt(defaultAvailableTime) * 60;
					JedisUtil.getJedisInstance().execSetexToCache(
							"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba",
							sessionAvailableTime, openid);
					// 设置cookie
					CookieUtil.setCookie(request, response, AuthApiCode.CMO2O_WX_MP_TOKEN,
							"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba", -1,
							"/");
					LOGGER.info("000000000000进入微信服务号授权成功，openid是：{}", openid);
					sessionAvailable = true;
				} else if (TradeFromType.CP.toString().equalsIgnoreCase(requestFrom)) {
					LOGGER.info("000000000000进入微信企业号授权通道.");
					String userInfo =
							"{\"mobile\":\"13951657704\",\"userId\":\"oFuguuFcIx0Kby\",\"weiXinId\":\"hhf_gyj\"}";
					// 将 用户信息存入Redis，默认有效时间为 sessionAvailableTime
					// 120分钟
					int sessionAvailableTime = Integer.parseInt(defaultAvailableTime) * 60;
					JedisUtil.getJedisInstance().execSetexToCache(
							"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba",
							sessionAvailableTime, userInfo);
					// 设置cookie
					CookieUtil.setCookie(request, response, AuthApiCode.CMO2O_WX_CP_TOKEN,
							"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba", -1,
							"/");
					LOGGER.info("000000000000进入微信企业号授权成功,用户信息为：{}", userInfo);
					sessionAvailable = true;
				}
			} else {
				if (TradeFromType.MP.toString().equalsIgnoreCase(requestFrom)) {
					LOGGER.info("进入微信服务号授权通道.");
					// 授权url
					WxMpOAuth2AccessToken accessToken = null;
					try {
						accessToken = wxMpService.oauth2getAccessToken(code);
					} catch (WxErrorException e) {
						LOGGER.error("获取微信服务号openid发生错误：" + e.getError().getErrorCode() + "："
								+ e.getError().getErrorMsg());
					}
					if (accessToken != null) {
						String openid = accessToken.getOpenId();
						// 将 openid存入Redis，默认有效时间为 sessionAvailableTime
						// 120分钟
						String uuid = UUIDUtils.getUUID();
						int sessionAvailableTime = Integer.parseInt(defaultAvailableTime) * 60;
						JedisUtil.getJedisInstance().execSetexToCache(
								CacheKeyRegistry.getWxOpenidForCacheKey(uuid), sessionAvailableTime,
								openid);
						// 设置cookie
						CookieUtil.setCookie(request, response, AuthApiCode.CMO2O_WX_MP_TOKEN,
								CacheKeyRegistry.getWxOpenidForCacheKey(uuid), -1, "/");
						LOGGER.info("进入微信服务号授权成功，openid是：{}", openid);
						sessionAvailable = true;
					}
				} else if (TradeFromType.CP.toString().equalsIgnoreCase(requestFrom)) {
					LOGGER.info("进入微信企业号授权通道.");
					if (Env.ENV_PROD.equals(Env.getSign())) {
						TokenRequest tokenRequest = new TokenRequest();
						tokenRequest.setCorpID(corpID);
						tokenRequest.setSecurityKey(securityKey);
						SimplePostRequestExecutor executor = new SimplePostRequestExecutor();
						try {
							String responseContent = executor.execute(httpClient, null,
									"http://weixin.midea.com/wxSdkService/cp/token/get",
									FastJSONHelper.serialize(tokenRequest));
							JSONObject jsonObj = JSONObject.parseObject(responseContent);
							String accessToken = jsonObj.getString("value");
							LOGGER.info("accessToken is {}", accessToken);
							if (!StringUtil.isBlank(accessToken)) {
								SimpleGetRequestExecutor executor_ = new SimpleGetRequestExecutor();
								String responseContent_ = executor_.execute(httpClient, null,
										"https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo",
										"access_token=" + accessToken + "&code=" + code);
								JSONObject jsonObj_ = JSONObject.parseObject(responseContent_);
								String userid = jsonObj_.getString("UserId");
								LOGGER.info("userid is {}", userid);
								if (!StringUtil.isBlank(userid)) {
									String userInfo = executor_.execute(httpClient, null,
											"https://qyapi.weixin.qq.com/cgi-bin/user/get",
											"access_token=" + accessToken + "&userid=" + userid);
									JSONObject userinfo = JSONObject.parseObject(userInfo);
									LOGGER.info("userinfo is {}", userInfo);
									String userid_ = userinfo.getString("userid");
									String weixinid = userinfo.getString("weixinid");
									String mobile = userinfo.getString("mobile");
									WxUserInfo wxUser = new WxUserInfo();
									wxUser.setUserId(userid_);
									wxUser.setWeiXinId(weixinid);
									wxUser.setMobile(mobile);
									LOGGER.info("根据userid:{}获取到的企业号用户信息为：{}", userid,
											FastJSONHelper.serialize(wxUser));
									String uuid = UUIDUtils.getUUID();
									int sessionAvailableTime =
											Integer.parseInt(defaultAvailableTime) * 60;
									JedisUtil.getJedisInstance().execSetexToCache(
											CacheKeyRegistry.getWxIdForCacheKey(uuid),
											sessionAvailableTime, FastJSONHelper.serialize(wxUser));
									// 设置cookie
									CookieUtil.setCookie(request, response,
											AuthApiCode.CMO2O_WX_CP_TOKEN,
											CacheKeyRegistry.getWxIdForCacheKey(uuid), -1, "/");
									LOGGER.info("进入微信企业号授权成功,用户信息为：{}",
											FastJSONHelper.serialize(wxUser));
									sessionAvailable = true;
								}
							}
						} catch (Exception e) {
							LOGGER.error("根据获取企业号用户信息失败", e);
						}
					} else {
						String[] userInfo = null;
						try {
							userInfo = wxCpService.oauth2getUserInfo(code);
						} catch (WxErrorException e) {
							LOGGER.error("根据code{}获取userid失败", code, e);
						}
						String userid = userInfo[0];
						try {
							WxCpUser user = wxCpService.userGet(userid);
							if (user != null) {
								WxUserInfo wxUser = new WxUserInfo();
								wxUser.setUserId(user.getUserId());
								wxUser.setWeiXinId(user.getWeiXinId());
								wxUser.setMobile(user.getMobile());
								LOGGER.info("根据userid:{}获取到的企业号用户信息为：{}", userid,
										FastJSONHelper.serialize(wxUser));
								// 将 用户信息存入Redis，默认有效时间为 sessionAvailableTime
								// 120分钟
								String uuid = UUIDUtils.getUUID();
								int sessionAvailableTime =
										Integer.parseInt(defaultAvailableTime) * 60;
								JedisUtil.getJedisInstance().execSetexToCache(
										CacheKeyRegistry.getWxIdForCacheKey(uuid),
										sessionAvailableTime, FastJSONHelper.serialize(wxUser));
								// 设置cookie
								CookieUtil.setCookie(request, response,
										AuthApiCode.CMO2O_WX_CP_TOKEN,
										CacheKeyRegistry.getWxIdForCacheKey(uuid), -1, "/");
								LOGGER.info("进入微信企业号授权成功,用户信息为：{}",
										FastJSONHelper.serialize(wxUser));
								sessionAvailable = true;
							}
						} catch (WxErrorException e) {
							LOGGER.error("根据userid:{}获取企业号用户信息失败", userid, e);
						}
					}
				}
			}
		}
		if (sessionAvailable) {
			ResponseError error = new ResponseError();
			error.setErrCode(BaseApiCode.OPERATE_SUCCESS);
			error.setZhMsg(BaseApiCode.getZhMsg(BaseApiCode.OPERATE_SUCCESS));
			return BodyData.make(true, error);
		} else {
			ResponseError error = new ResponseError();
			error.setErrCode(AuthApiCode.NO_AUTHORIZATION);
			error.setZhMsg(BaseApiCode.getZhMsg(AuthApiCode.NO_AUTHORIZATION));
			return BodyData.make(false, error);
		}
	}
}
