package com.dongyuan.figting.impl.controller;

import java.util.List;

import com.dongyuan.figting.impl.code.BaseApiCode;
import com.dongyuan.figting.impl.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongyuan.figting.impl.core.excute.ControllerWrapper;
import com.dongyuan.figting.impl.core.excute.CtrlRespPackUtil;
import com.dongyuan.figting.impl.dto.BodyData;
import com.dongyuan.figting.impl.dto.request.TicketCommonRequest;
import com.dongyuan.figting.impl.dto.response.OrderInfoRes;
import com.dongyuan.figting.impl.utils.FastJSONHelper;

/**
 * 类TicketController.java的实现描述：认筹券控制器
 * 
 * @author huanghf 2015年12月26日 下午1:41:19
 * @email haifeng1.huang@midea.com
 */
@Controller
@RequestMapping("order")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private IOrderService orderService;

	/**
	 * 根据ticketId获取订单列表
	 * 
	 * @param openidToken
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody BodyData
			list(@RequestParam(value = "ticketId", required = true) String ticketId) {
		LOGGER.info("根据认筹券号{}获取订单列表.", ticketId);
		final TicketCommonRequest request = new TicketCommonRequest();
		request.setTicketId(ticketId);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				List<OrderInfoRes> orders = orderService.getOrdersByTicketId(request.getTicketId());
				LOGGER.info("获取认筹券号：{}的订单列表如下：{}", request.getTicketId(),
						FastJSONHelper.serialize(orders));
				response.setContent(orders);
				return BaseApiCode.OPERATE_SUCCESS;
			}
		});
	}
}
