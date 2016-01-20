package com.dongyuan.figting.controller;

import java.util.List;

import com.dongyuan.figting.code.BaseApiCode;
import com.dongyuan.figting.code.TicketApiCode;
import com.dongyuan.figting.dto.request.AddressModifyRequest;
import com.dongyuan.figting.service.IAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.midea.cmo2o.ticket.api.dto.ResultCode;
import com.dongyuan.figting.core.excute.ControllerWrapper;
import com.dongyuan.figting.core.excute.CtrlRespPackUtil;
import com.dongyuan.figting.dto.BodyData;
import com.dongyuan.figting.dto.request.AddressCommonRequest;
import com.dongyuan.figting.dto.request.AddressRequest;
import com.dongyuan.figting.dto.request.TicketCommonRequest;
import com.dongyuan.figting.dto.response.AddressInfoRes;
import com.dongyuan.figting.utils.FastJSONHelper;

/**
 * 类AddressController.java的实现描述：收货地址控制器
 * 
 * @author huanghf 2015年12月26日 下午1:41:19
 * @email haifeng1.huang@midea.com
 */
@Controller
@RequestMapping("address")
public class AddressController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private IAddressService addressService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody BodyData
			list(@RequestParam(value = "ticketId", required = true) String ticketId) {

		final TicketCommonRequest request = new TicketCommonRequest();
		request.setTicketId(ticketId);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				List<AddressInfoRes> addrs =
						addressService.getAddrsByTicketId(request.getTicketId());
				response.setContent(addrs);
				LOGGER.info("获取认筹券号：{}的地址列表信息如下：{}.", request.getTicketId(),
						FastJSONHelper.serialize(addrs));
				return BaseApiCode.OPERATE_SUCCESS;
			}
		});
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody BodyData add(@RequestBody
	final AddressRequest addressRequest) {
		LOGGER.info("添加认筹券号：{}对应的地址列表.", addressRequest.getTicketId());
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(addressRequest, response,
				new ControllerWrapper() {

					@Override
					public String invokeService() {
						Long result = addressService.addAddress(addressRequest);
						if (result != null) {
							if (ResultCode.EXCEED_MAX_ADDRESSES == result) {
								LOGGER.info("添加认筹券号：{}对应的地址列表-失败-不能超过十条.",
										addressRequest.getTicketId());
								response.setContent(false);
								return TicketApiCode.EXCEED_MAX_ADDRESSES;
							}
							LOGGER.info("添加认筹券号：{}对应的地址列表-成功.", addressRequest.getTicketId());
							response.setContent(true);
							return BaseApiCode.OPERATE_SUCCESS;
						}
						LOGGER.info("添加认筹券号：{}对应的地址列表-失败.", addressRequest.getTicketId());
						response.setContent(false);
						return BaseApiCode.OPERATE_FAIL;
					}
				});
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public @ResponseBody BodyData update(@RequestBody
	final AddressModifyRequest addressModifyRequest) {
		LOGGER.info("修改id为：{}的地址.", addressModifyRequest.getId());
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(addressModifyRequest, response,
				new ControllerWrapper() {

					@Override
					public String invokeService() {
						boolean flag = addressService.updateAddress(addressModifyRequest);
						if (flag) {
							LOGGER.info("修改id为：{}的地址-成功.", addressModifyRequest.getId());
							response.setContent(true);
							return BaseApiCode.OPERATE_SUCCESS;
						}
						LOGGER.info("修改认id为：{}的地址-失败.", addressModifyRequest.getId());
						response.setContent(false);
						return BaseApiCode.OPERATE_FAIL;
					}
				});
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody BodyData delete(@RequestParam(value = "id", required = true) Long id) {
		LOGGER.info("删除id为：{}的地址.", id);
		final AddressCommonRequest request = new AddressCommonRequest();
		request.setAddressId(id);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				boolean flag = addressService.deleteAddress(request.getAddressId());
				if (flag) {
					LOGGER.info("删除id为：{}的地址-成功.", request.getAddressId());
					response.setContent(true);
					return BaseApiCode.OPERATE_SUCCESS;
				}
				LOGGER.info("删除id为：{}的地址-失败.", request.getAddressId());
				response.setContent(false);
				return BaseApiCode.OPERATE_FAIL;
			}
		});
	}

}
