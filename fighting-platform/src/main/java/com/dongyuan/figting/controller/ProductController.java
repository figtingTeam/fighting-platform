package com.dongyuan.figting.controller;

import java.util.Map;

import com.dongyuan.figting.Constants;
import com.dongyuan.figting.code.BaseApiCode;
import com.dongyuan.figting.dto.request.ProductRequest;
import com.dongyuan.figting.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.midea.cmo2o.shopping.api.domain.ProductDetail;
import com.dongyuan.figting.core.excute.ControllerWrapper;
import com.dongyuan.figting.core.excute.CtrlRespPackUtil;
import com.dongyuan.figting.dto.BodyData;
import com.dongyuan.figting.utils.StringUtil;
import com.midea.trade.common.util.FastJSONHelper;

/**
 * 类ProductController.java的实现描述：商品控制器
 * 
 * @author huanghf 2015年12月28日 下午6:36:40
 * @email haifeng1.huang@midea.com
 */
@Controller
@RequestMapping("product")
public class ProductController {
	private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IProductService productService;

	/**
	 * 根据商品短码和活动ID获取商品信息
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public @ResponseBody BodyData info(
			@RequestParam(value = "shortCode", required = true) String shortCode,
			@RequestParam(value = "activityId", required = true) Long activityId) {
		final ProductRequest request = new ProductRequest();
		request.setActivityId(activityId);
		request.setShortCode(shortCode);
		final BodyData response = BodyData.make();
		return CtrlRespPackUtil.execInvokeService(request, response, new ControllerWrapper() {

			@Override
			public String invokeService() {
				Map<String, Object> resultMap = productService
						.getProductInfo(request.getActivityId(), request.getShortCode());
				String errorCode = (String) resultMap.get(Constants.RESPONSE_NAME);
				if (StringUtil.isBlank(errorCode)) {
					ProductDetail productInfo =
							(ProductDetail) resultMap.get(Constants.RESPONSE_CONTENT);
					LOGGER.info("获取到的商品信息如下：{}", FastJSONHelper.serialize(productInfo));
					response.setContent(productInfo);
					return BaseApiCode.OPERATE_SUCCESS;
				}
				return errorCode;
			}
		});
	}

}