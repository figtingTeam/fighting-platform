package com.midea.cmo2o.wx.impl.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.midea.cmo2o.shopping.api.domain.ShoppingCartInfo;
import com.midea.cmo2o.wx.impl.Constants;
import com.midea.cmo2o.wx.impl.code.BaseApiCode;
import com.midea.cmo2o.wx.impl.core.excute.ControllerWrapper;
import com.midea.cmo2o.wx.impl.core.excute.CtrlRespPackUtil;
import com.midea.cmo2o.wx.impl.dto.BodyData;
import com.midea.cmo2o.wx.impl.dto.request.CartAddRequest;
import com.midea.cmo2o.wx.impl.dto.request.CartDeleteRequest;
import com.midea.cmo2o.wx.impl.dto.request.CartModifyRequest;
import com.midea.cmo2o.wx.impl.dto.request.TicketRequest;
import com.midea.cmo2o.wx.impl.dto.response.AddressInfoRes;
import com.midea.cmo2o.wx.impl.dto.response.ShoppingCartInfoRes;
import com.midea.cmo2o.wx.impl.service.IAddressService;
import com.midea.cmo2o.wx.impl.service.IShoppingCartService;
import com.midea.cmo2o.wx.impl.utils.FastJSONHelper;
import com.midea.cmo2o.wx.impl.utils.StringUtil;

/**
 * 类ShoppingCartController.java的实现描述：购物车控制器
 * 
 * @author huanghf 2016年1月2日 上午10:06:31
 * @email haifeng1.huang@midea.com
 */
@Controller
@RequestMapping("cart")
public class ShoppingCartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartController.class);

	@Autowired
	private IShoppingCartService shoppingCartService;

	@Autowired
	private IAddressService addressService;

	/**
	 * 获得购物车列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody BodyData list(
			@RequestParam(value = "ticketId", required = true) String ticketId,
			@RequestParam(value = "activityId", required = true) Long activityId) {
		LOGGER.info("获取认筹券号:{}的购物车列表", ticketId);
		final TicketRequest request = new TicketRequest();
		request.setTicketId(ticketId);
		request.setActivityId(activityId);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				ShoppingCartInfoRes shoppingCartInfoRes = new ShoppingCartInfoRes();
				Map<String, Object> resultMap =
						shoppingCartService.list(request.getTicketId(), request.getActivityId());
				String errorCode = (String) resultMap.get(Constants.RESPONSE_NAME);
				if (StringUtil.isBlank(errorCode)) {
					ShoppingCartInfo cartInfo =
							(ShoppingCartInfo) resultMap.get(Constants.RESPONSE_CONTENT);
					List<AddressInfoRes> addresss =
							addressService.getAddrsByTicketId(request.getTicketId());
					if (CollectionUtils.isNotEmpty(addresss)) {
						shoppingCartInfoRes.setAddress(addresss.get(0));
					}
					shoppingCartInfoRes.setShoppingCartInfo(cartInfo);
					response.setContent(shoppingCartInfoRes);
					LOGGER.info("认筹券号：{}购物车列表信息如下：{}", request.getTicketId(),
							FastJSONHelper.serialize(shoppingCartInfoRes));
					return BaseApiCode.OPERATE_SUCCESS;

				}
				LOGGER.info("获取认筹券号：{}购物车列表信息失败，返回错误码：{}", request.getTicketId(), errorCode);
				return errorCode;
			}
		});
	}

	/**
	 * 添加购物车商品
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody BodyData add(@RequestBody
	final CartAddRequest cartAddRequest) {
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(cartAddRequest, response,
				new ControllerWrapper() {

					@Override
					public String invokeService() {
						String resultCode = shoppingCartService.addItem(cartAddRequest);
						if (StringUtil.isBlank(resultCode)) {
							LOGGER.info("添加购物车成功...");
							response.setContent(true);
							return BaseApiCode.OPERATE_SUCCESS;
						}
						LOGGER.info("添加购物车失败...");
						response.setContent(false);
						return resultCode;
					}
				});
	}

	/**
	 * 修改购物车数量
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public @ResponseBody BodyData modifyCount(@RequestBody
	final CartModifyRequest cartModifyRequest) {
		LOGGER.info("修改购物车数量，入参{}.", FastJSONHelper.serialize(cartModifyRequest));
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(cartModifyRequest, response,
				new ControllerWrapper() {

					@Override
					public String invokeService() {
						String resultCode = shoppingCartService.modifyCount(cartModifyRequest);
						if (StringUtil.isBlank(resultCode)) {
							LOGGER.info("修改购物车数量成功...");
							ShoppingCartInfoRes shoppingCartInfoRes = new ShoppingCartInfoRes();
							Map<String, Object> resultMap =
									shoppingCartService.list(cartModifyRequest.getTicketId(),
											cartModifyRequest.getActivityId());
							ShoppingCartInfo cartInfo =
									(ShoppingCartInfo) resultMap.get(Constants.RESPONSE_CONTENT);
							shoppingCartInfoRes.setShoppingCartInfo(cartInfo);
							List<AddressInfoRes> addresss = addressService
									.getAddrsByTicketId(cartModifyRequest.getTicketId());
							if (CollectionUtils.isNotEmpty(addresss)) {
								shoppingCartInfoRes.setAddress(addresss.get(0));
							}
							// 修改数量返回成功
							response.setContent(shoppingCartInfoRes);
							return BaseApiCode.OPERATE_SUCCESS;
						}
						LOGGER.info("修改购物车数量失败.");
						return resultCode;
					}

				});
	}

	/**
	 * 删除购物车中商品
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody BodyData deleteshopping(@RequestBody
	final CartDeleteRequest cartDeleteRequest) {
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(cartDeleteRequest, response,
				new ControllerWrapper() {

					@Override
					public String invokeService() {
						String resultCode = shoppingCartService.deleteItem(cartDeleteRequest);
						if (StringUtil.isBlank(resultCode)) {
							ShoppingCartInfoRes shoppingCartInfoRes = new ShoppingCartInfoRes();
							Map<String, Object> resultMap =
									shoppingCartService.list(cartDeleteRequest.getTicketId(),
											cartDeleteRequest.getActivityId());
							ShoppingCartInfo cartInfo =
									(ShoppingCartInfo) resultMap.get(Constants.RESPONSE_CONTENT);
							List<AddressInfoRes> addresss = addressService
									.getAddrsByTicketId(cartDeleteRequest.getTicketId());
							if (CollectionUtils.isNotEmpty(addresss)) {
								shoppingCartInfoRes.setAddress(addresss.get(0));
							}
							shoppingCartInfoRes.setShoppingCartInfo(cartInfo);
							response.setContent(shoppingCartInfoRes);
							return BaseApiCode.OPERATE_SUCCESS;
						}
						return resultCode;
					}

				});
	}

}
