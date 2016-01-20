package com.dongyuan.figting.impl.controller;

import java.util.List;

import com.dongyuan.figting.impl.code.AuthApiCode;
import com.dongyuan.figting.impl.code.BaseApiCode;
import com.dongyuan.figting.impl.core.excute.ControllerWrapper;
import com.dongyuan.figting.impl.dto.BodyData;
import com.dongyuan.figting.impl.dto.request.TicketRequest;
import com.dongyuan.figting.impl.dto.response.ActivityDataRes;
import com.dongyuan.figting.impl.dto.response.ActivityInfoRes;
import com.dongyuan.figting.impl.service.ITicketService;
import com.dongyuan.figting.impl.service.IWxUserService;
import com.dongyuan.figting.impl.utils.FastJSONHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongyuan.figting.impl.core.excute.CtrlRespPackUtil;
import com.dongyuan.figting.impl.dto.request.ActivityListRequest;
import com.dongyuan.figting.impl.dto.response.WxUserInfo;
import com.dongyuan.figting.impl.service.WWorkerService;

/**
 * 类ActivityController.java的实现描述：活动控制器
 * 
 * @author huanghf 2016年1月2日 上午9:26:16
 * @email haifeng1.huang@midea.com
 */
@Controller
@RequestMapping("activity")
public class ActivityController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);

	@Autowired
	private ITicketService ticketService;

	@Autowired
	private WWorkerService wWorkerService;

	@Autowired
	private IWxUserService wxUserService;

	/**
	 * 获得卡券-活动首页
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public @ResponseBody
	BodyData info(
			@RequestParam(value = "ticketId", required = true) String ticketId,
			@RequestParam(value = "activityId", required = true) Long activityId) {
		LOGGER.info("根据认筹券号：{}获取活动{}的信息.", ticketId, activityId);
		final TicketRequest request = new TicketRequest();
		request.setTicketId(ticketId);
		request.setActivityId(activityId);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				ActivityInfoRes ticket = ticketService.getActivityByTicketId(request.getTicketId(),
						request.getActivityId());
				LOGGER.info("获取到的活动信息如下：{}", FastJSONHelper.serialize(ticket));
				response.setContent(ticket);
				return BaseApiCode.OPERATE_SUCCESS;
			}
		});
	}

	/**
	 * 企业号，获取本导购所参与活动列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody BodyData activityList(
			@CookieValue(value = AuthApiCode.CMO2O_WX_CP_TOKEN, required = true) String token) {

		WxUserInfo userInfo = wxUserService.getUserInfoByToken(token);
		String mobile = userInfo.getMobile();
		String weiXinId = userInfo.getWeiXinId();
		LOGGER.info("获取导购：{}当前的活动列表.", weiXinId);
		final ActivityListRequest request = new ActivityListRequest();
		// 此处ActivityListRequest内的wxCode和mobile没有做两个不能同时为空的限制，所以前端即使传两个空过来，此处也不会警告，实际过程中不应该出现两个同时为空
		request.setWxCode(weiXinId);
		request.setMobile(mobile);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				List<ActivityDataRes> list = wWorkerService
						.getActivityListByWxCode(request.getWxCode(), request.getMobile());
				LOGGER.info("获取到的活动列表信息如下：{}", FastJSONHelper.serialize(list));
				response.setContent(list);
				return BaseApiCode.OPERATE_SUCCESS;
			}
		});
	}
}
