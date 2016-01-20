package com.midea.cmo2o.wx.impl.code;

import java.util.Map;

public class TicketApiCode {

	/** 认筹券没有激活 **/
	public static final String TICKET_NOT_ACTIVE = "2000";

	/** 认筹券不可用 **/
	public static final String TICKET_NOT_AVAILABLE = "2012";

	/** 该券已过期，过期时间为【有效期截止时间，2015年9月16日】 **/
	public static final String TICKET_EXPIRE = "2001";

	/** 该券不存在，请联系工作人员确认券号 **/
	public static final String TICKET_NOT_EXIST = "2002";

	/** 券号已经被激活，但未关联任何openid **/
	public static final String TICKET_NOT_LINK_OPENID = "2003";

	/** 该券已被其它用户激活 **/
	public static final String TICKET_ACTIVATED_OTHER = "2004";

	/** 该券已本用户激活，请勿重复激活 **/
	public static final String TICKET_ACTIVATED_SELF = "2005";

	/** 本微信号已经绑定过本次活动的另一张认筹券 **/
	public static final String OPENID_LINK_OTHER_TICKET = "2006";

	/** 激活失败 **/
	public static final String TICKET_ACTIVATED_FAIL = "2007";

	/** 手机号已绑定本次活动的另一张认筹券 **/
	public static final String MOBILE_LINK_OTHER_TICKET = "2008";

	/** 本次活动不存在该券 **/
	public static final String TICKET_NOT_EXIST_THIS_ACTIVITY = "2009";

	/** 此电话号码未绑定本活动认筹券 **/
	public static final String MOBILE_NOT_LINK_THIS_ACTIVITY = "2010";

	/** 该电话号码绑定的本次活动中的认筹券已过期 **/
	public static final String MOBILE_TICKET_EXPIRE = "2011";

	/** 认筹券号或手机号不能为空 **/
	public static final String MOBILE_TICKETID_NOT_BLAND = "2013";

	/** 验证码获取失败，请重新获取 **/
	public static final String GET_CAPTCHA_FAIL = "6001";

	/** 手机号不能为空 **/
	public static final String BLANK_MOBILE = "6002";

	/** 验证码错误 **/
	public static final String CAPTCHA_ERROR = "3000";

	/** 验证码过期 **/
	public static final String CAPTCHA_EXPIRE = "3001";

	/** 验证失败 **/
	public static final String BIND_FAIL = "3002";

	/** 达到最大地址数量 **/
	public static final String EXCEED_MAX_ADDRESSES = "7018";

	public static void initResponseCode() {
		Map<String, String> enMsgMap = BaseApiCode.enMsgMap;
		Map<String, String> zhMsgMap = BaseApiCode.zhMsgMap;
		enMsgMap.put(GET_CAPTCHA_FAIL, "ticket.get_captcha_fail");
		zhMsgMap.put(GET_CAPTCHA_FAIL, "验证码获取失败，请重新获取");
		enMsgMap.put(BLANK_MOBILE, "ticket.blank_mobile");
		zhMsgMap.put(BLANK_MOBILE, "手机号不能为空");
		enMsgMap.put(CAPTCHA_ERROR, "ticket.captcha_error");
		zhMsgMap.put(CAPTCHA_ERROR, "验证码错误");
		enMsgMap.put(CAPTCHA_EXPIRE, "ticket.check_fail");
		zhMsgMap.put(CAPTCHA_EXPIRE, "验证码过期");
		enMsgMap.put(BIND_FAIL, "ticket.bind_fail");
		zhMsgMap.put(BIND_FAIL, "验证失败");

		enMsgMap.put(TICKET_NOT_ACTIVE, "ticket.ticket_not_active");
		zhMsgMap.put(TICKET_NOT_ACTIVE, "认筹券没有激活");
		enMsgMap.put(TICKET_EXPIRE, "ticket.ticket_expire");
		zhMsgMap.put(TICKET_EXPIRE, "该券已过期");
		enMsgMap.put(TICKET_NOT_EXIST, "ticket.ticket_not_exist");
		zhMsgMap.put(TICKET_NOT_EXIST, "该券不存在，请联系工作人员确认券号");
		enMsgMap.put(TICKET_NOT_LINK_OPENID, "ticket.ticket_not_link_openid");
		zhMsgMap.put(TICKET_NOT_LINK_OPENID, "券号已经被激活，但未关联任何openid");
		enMsgMap.put(TICKET_ACTIVATED_OTHER, "ticket.ticket_activated_other");
		zhMsgMap.put(TICKET_ACTIVATED_OTHER, "该券已被其它用户激活");
		enMsgMap.put(TICKET_ACTIVATED_SELF, "ticket.ticket_activated_self");
		zhMsgMap.put(TICKET_ACTIVATED_SELF, "该券已本用户激活，请勿重复激活");
		enMsgMap.put(OPENID_LINK_OTHER_TICKET, "ticket.openid_link_other_ticket");
		zhMsgMap.put(OPENID_LINK_OTHER_TICKET, "本微信号已经绑定过本次活动的另一张认筹券");
		enMsgMap.put(TICKET_ACTIVATED_FAIL, "ticket.ticket_activated_fail");
		zhMsgMap.put(TICKET_ACTIVATED_FAIL, "认筹券激活失败");
		enMsgMap.put(MOBILE_LINK_OTHER_TICKET, "ticket.mobile_link_other_ticket");
		zhMsgMap.put(MOBILE_LINK_OTHER_TICKET, "认筹券激活失败");
		enMsgMap.put(TICKET_NOT_EXIST_THIS_ACTIVITY, "ticket.ticket_not_exist_this_activity");
		zhMsgMap.put(TICKET_NOT_EXIST_THIS_ACTIVITY, "本次活动不存在该券");
		enMsgMap.put(MOBILE_NOT_LINK_THIS_ACTIVITY, "ticket.mobile_not_link_this_activity");
		zhMsgMap.put(MOBILE_NOT_LINK_THIS_ACTIVITY, "此电话号码未绑定本活动认筹券");
		enMsgMap.put(TICKET_NOT_AVAILABLE, "ticket.ticket_not_available");
		zhMsgMap.put(TICKET_NOT_AVAILABLE, "认筹券不可用");
		enMsgMap.put(MOBILE_TICKET_EXPIRE, "ticket.mobile_ticket_expire");
		zhMsgMap.put(MOBILE_TICKET_EXPIRE, "该电话号码绑定的本次活动中的认筹券已过期");
		enMsgMap.put(MOBILE_TICKETID_NOT_BLAND, "ticket.mobile_ticketid_not_bland");
		zhMsgMap.put(MOBILE_TICKETID_NOT_BLAND, "认筹券号或手机号不能为空");
		enMsgMap.put(EXCEED_MAX_ADDRESSES, "ticket.exceed_max_addresses");
		zhMsgMap.put(EXCEED_MAX_ADDRESSES, "达到最大地址数量");

	}
}
