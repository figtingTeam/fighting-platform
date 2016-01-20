package com.dongyuan.figting.controller;

import java.util.List;

import com.dongyuan.figting.Constants;
import com.dongyuan.figting.code.AuthApiCode;
import com.dongyuan.figting.core.excute.ControllerWrapper;
import com.dongyuan.figting.core.excute.CtrlRespPackUtil;
import com.dongyuan.figting.dto.BodyData;
import com.dongyuan.figting.dto.request.ActivityInfoRequest;
import com.dongyuan.figting.dto.request.SmsCaptchaRequest;
import com.dongyuan.figting.dto.request.TicketActivateRequest;
import com.dongyuan.figting.dto.request.TicketBindRequest;
import com.dongyuan.figting.dto.response.TicketAddrInfoRes;
import com.dongyuan.figting.dto.response.TicketBasicInfoRes;
import com.dongyuan.figting.code.BaseApiCode;
import com.dongyuan.figting.code.TicketApiCode;
import com.dongyuan.figting.dto.request.TicketCheckRequest;
import com.dongyuan.figting.service.ITicketService;
import com.dongyuan.figting.service.IWxUserService;
import com.dongyuan.figting.utils.DateUtil;
import com.dongyuan.figting.service.ISmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongyuan.figting.dto.request.WxUserRequest;
import com.dongyuan.figting.utils.StringUtil;

/**
 * 类TicketController.java的实现描述：认筹券控制器
 * 
 * @author huanghf 2015年12月26日 下午1:41:19
 * @email haifeng1.huang@midea.com
 */
@Controller
@RequestMapping("ticket")
public class TicketController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TicketController.class);

	@Autowired
	private IWxUserService wxUserService;

	@Autowired
	private ITicketService ticketService;

	@Autowired
	private ISmsService smsService;

	/**
	 * 根据openid获取认筹券列表 1）用户首次进入【我的认筹券】页面，认筹券列表为空，仅显示“添加认筹券”按钮；
	 * 2）用户已经激活过认筹券，再进入【我的认筹券】页面，通过第一次激活时已经绑定微信号openid获取认筹券列表；
	 * 3）认筹券列表所列示的卡券，若该卡券所关联的活动已经结束，则卡券上的按钮显示为灰色的“活动已结束”，按钮仍可点击，点击后进入【活动首页】（
	 * 已结束的活动）
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	BodyData list(
			@CookieValue(value = AuthApiCode.CMO2O_WX_MP_TOKEN, required = true) String openidToken) {

		LOGGER.info("openidToken：{}", openidToken);
		// redis中获取openid，如果openid在redis中已过期，则请求在拦截器处就被告知未授权，不会进到该接口,因此此处openid不可能为null
		final String openid = wxUserService.getOpenidByToken(openidToken);
		final WxUserRequest request = new WxUserRequest();
		request.setOpenid(openid);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				List<TicketBasicInfoRes> tickets =
						ticketService.getTicketsByOpenid(request.getOpenid());
				response.setContent(tickets);
				return BaseApiCode.OPERATE_SUCCESS;
			}
		});
	}

	/**
	 * 校验认筹券 a.券号已过期---提示：该券已过期，过期时间为【有效期截止时间，2015年9月16日】；
	 * b.券号不存在---提示：该券不存在，请联系工作人员确认券号； c.券号已经被激活，但未关联任何openid——跳转【已绑定手机号验证】页面；
	 * d.券号已经被激活，但关联的openid非本微信号；——提示框：该券已被其它用户激活；
	 * e.券号已经被激活，但关联的openid就是本微信号；——提示框：该券已激活，请勿重复激活； f.券号尚未被激活且可用——跳转【资料登记】页面；
	 * f.该openid已绑定本次活动的其他券号；——提示框：本微信号已经绑定本次活动的另一张认筹券
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public @ResponseBody BodyData check(
			@CookieValue(value = AuthApiCode.CMO2O_WX_MP_TOKEN, required = true) String openidToken,
			@RequestParam(value = "ticketId", required = true) String ticketId) {
		final String openid = wxUserService.getOpenidByToken(openidToken);
		final TicketCheckRequest request = new TicketCheckRequest();
		request.setOpenid(openid);
		request.setTicketId(ticketId);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				String resultCode =
						ticketService.checkTicket(request.getOpenid(), request.getTicketId());
				if (DateUtil.isDate(resultCode)) {
					// 该券已过期，过期时间为【有效期截止时间，2015年9月16日】注：过期时间放在content中
					response.setContent(resultCode);
					return TicketApiCode.TICKET_EXPIRE;
				} else {
					if (resultCode.contains("_ACTIVITYID")) {
						// 券号可激活 注：活动ID放在content中
						String activityId = resultCode.split("_")[0];
						response.setContent(activityId);
						return TicketApiCode.TICKET_NOT_ACTIVE;
					} else {
						if (resultCode.length() > Constants.CONSTANT_FOUR_INT) {
							// 券号已经被激活，但未关联任何openid 注：已绑定的手机号放在content中
							response.setContent(resultCode);
							return TicketApiCode.TICKET_NOT_LINK_OPENID;
						}
					}
				}
				return resultCode;
			}
		});
	}

	/**
	 * 获取短信验证码
	 */
	@RequestMapping(value = "/smsCaptcha", method = RequestMethod.GET)
	public @ResponseBody BodyData
			smsCaptcha(@RequestParam(value = "mobile", required = true) String mobile) {
		final SmsCaptchaRequest request = new SmsCaptchaRequest();
		request.setMobile(mobile);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				String resultCode = smsService.sendCaptcha(request.getMobile());
				if (BaseApiCode.OPERATE_SUCCESS.equals(resultCode)) {
					response.setContent(true);
				} else {
					response.setContent(false);
				}
				return resultCode;
			}
		});
	}

	/**
	 * 添加认筹券（已激活的认筹券关联openid）
	 */
	@RequestMapping(value = "/bind", method = RequestMethod.POST)
	public @ResponseBody BodyData bind(
			@CookieValue(value = AuthApiCode.CMO2O_WX_MP_TOKEN, required = true) String openidToken,
			@RequestBody
	final TicketBindRequest request) {
		final String openid = wxUserService.getOpenidByToken(openidToken);
		request.setOpenid(openid);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				String resultCode = ticketService.bindOpenid(request);
				if (BaseApiCode.OPERATE_SUCCESS.equals(resultCode)) {
					response.setContent(true);
				} else {
					response.setContent(false);
				}
				return resultCode;
			}
		});
	}

	/**
	 * 激活认筹券
	 */
	@RequestMapping(value = "/activate", method = RequestMethod.POST)
	public @ResponseBody BodyData activate(
			@CookieValue(value = AuthApiCode.CMO2O_WX_MP_TOKEN, required = true) String openidToken,
			@RequestBody
	final TicketActivateRequest request) {
		final String openid = wxUserService.getOpenidByToken(openidToken);
		request.setOpenid(openid);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				String resultCode = ticketService.activate(request);
				if (BaseApiCode.OPERATE_SUCCESS.equals(resultCode)) {
					response.setContent(true);
				} else {
					response.setContent(false);
				}
				return resultCode;
			}
		});
	}

	/**
	 * 企业号输入认筹券号或手机号查找出用户信息
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody BodyData queryById(
			@RequestParam(value = "ticketId", required = false) String ticketId,
			@RequestParam(value = "mobile", required = false) String mobile,
			@RequestParam(value = "activityId", required = true) Long activityId) {

		final ActivityInfoRequest request = new ActivityInfoRequest();
		request.setTicketId(ticketId);
		request.setMobile(mobile);
		request.setActivityId(activityId);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				if (StringUtil.isBlank(request.getTicketId())
						&& StringUtil.isBlank(request.getMobile())) {
					return TicketApiCode.MOBILE_TICKETID_NOT_BLAND;
				}
				TicketAddrInfoRes ticketAddr = ticketService.getTicket(request.getTicketId(),
						request.getMobile(), request.getActivityId());
				if (StringUtil.isBlank(request.getMobile())) {
					// 结果是通过认筹券号查询的
					if (ticketAddr == null) {
						return TicketApiCode.TICKET_NOT_EXIST_THIS_ACTIVITY;
					}
					if (ticketAddr.getActivateTime() == null) {
						return TicketApiCode.TICKET_NOT_ACTIVE;
					}
				}
				if (StringUtil.isBlank(request.getTicketId())) {
					// 结果是通过手机号查询的
					if (ticketAddr == null) {
						return TicketApiCode.MOBILE_NOT_LINK_THIS_ACTIVITY;
					}
				}
				response.setContent(ticketAddr);
				return BaseApiCode.OPERATE_SUCCESS;
			}
		});
	}
}
