package com.dongyuan.figting.impl.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.dongyuan.figting.impl.code.BaseApiCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midea.cmo2o.shopping.api.domain.ShoppingCartInfo;
import com.midea.cmo2o.shopping.api.dto.request.cart.ShoppingCartAddRequest;
import com.midea.cmo2o.shopping.api.dto.request.cart.ShoppingCartChangeNumRequest;
import com.midea.cmo2o.shopping.api.dto.request.cart.ShoppingCartCommonRequest;
import com.midea.cmo2o.shopping.api.dto.request.cart.ShoppingCartQueryRequest;
import com.midea.cmo2o.shopping.api.dto.response.BaseResponse;
import com.midea.cmo2o.shopping.api.dto.response.cart.ShoppingCartCommonResponse;
import com.midea.cmo2o.shopping.api.dto.response.cart.ShoppingCartQueryResponse;
import com.midea.cmo2o.shopping.api.service.ShoppingCartFacade;
import com.midea.cmo2o.ticket.api.WorkerServiceFacade;
import com.midea.cmo2o.ticket.api.dto.Result;
import com.midea.cmo2o.ticket.api.dto.WorkerData;
import com.dongyuan.figting.impl.Constants;
import com.dongyuan.figting.impl.code.ProductApiCode;
import com.dongyuan.figting.impl.code.ShoppingCartApiCode;
import com.dongyuan.figting.impl.code.TicketApiCode;
import com.dongyuan.figting.impl.dto.request.CartAddRequest;
import com.dongyuan.figting.impl.dto.request.CartDeleteRequest;
import com.dongyuan.figting.impl.dto.request.CartModifyRequest;
import com.dongyuan.figting.impl.service.IShoppingCartService;
import com.dongyuan.figting.impl.utils.DateStyle;
import com.dongyuan.figting.impl.utils.DateUtil;
import com.dongyuan.figting.impl.utils.StringUtil;
import com.midea.trade.common.util.FastJSONHelper;

@Service(value = "shoppingCartService")
public class ShoppingCartServiceImpl implements IShoppingCartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

	@Autowired
	private ShoppingCartFacade shoppingCartFacade;

	@Autowired
	private WorkerServiceFacade workerServiceFacade;

	@Override
	public String modifyCount(CartModifyRequest cartModifyRequest) {
		// 每个商品最大限购99，修改数量前台传全量
		if (cartModifyRequest.getCount() > 99) {
			return ShoppingCartApiCode.SKU_NUM_MAX_LIMIT;
		}
		ShoppingCartChangeNumRequest cartChangeNumReq = new ShoppingCartChangeNumRequest();
		cartChangeNumReq.setShoppingCartId(cartModifyRequest.getShoppingCartId());
		cartChangeNumReq.setTicketId(cartModifyRequest.getTicketId());
		cartChangeNumReq.setCount(cartModifyRequest.getCount());
		cartChangeNumReq.setUpdateTime(DateUtil.StringToDate(cartModifyRequest.getUpdateTime(),
				DateStyle.YYYY_MM_DD_HH_MM_SS));
		BaseResponse baseReq = shoppingCartFacade.changeShoppingCartNum(cartChangeNumReq);
		return baseReq.getErrorCode();
	}

	@Override
	public String deleteItem(CartDeleteRequest cartDeleteRequest) {
		ShoppingCartCommonRequest shoppingCartReq = new ShoppingCartCommonRequest();
		BeanUtils.copyProperties(cartDeleteRequest, shoppingCartReq);
		BaseResponse baseReq = shoppingCartFacade.deleteShoppingCart(shoppingCartReq);
		return baseReq.getErrorCode();
	}

	@Override
	public String addItem(CartAddRequest cartAddRequest) {
		// 判断导购员编码是否存在
		if (cartAddRequest.getSalesmanId() != null) {
			Result<WorkerData> result = workerServiceFacade.getWorker(
					cartAddRequest.getActivityId(), (long) cartAddRequest.getSalesmanId());
			if (!result.isOk()) {
				return ShoppingCartApiCode.SALE_MAN_NOT_EXIST;
			}
		}
		ShoppingCartAddRequest cartAddReq = new ShoppingCartAddRequest();
		BeanUtils.copyProperties(cartAddRequest, cartAddReq);
		ShoppingCartCommonResponse shopcartReq = shoppingCartFacade.addShoppingCart(cartAddReq);
		if ("701".equals(shopcartReq.getErrorCode())) {
			return TicketApiCode.TICKET_NOT_EXIST;
		} else if ("702".equals(shopcartReq.getErrorCode())) {
			return TicketApiCode.TICKET_NOT_AVAILABLE;
		} else if ("703".equals(shopcartReq.getErrorCode())) {
			return TicketApiCode.TICKET_NOT_ACTIVE;
		} else if ("602".equals(shopcartReq.getErrorCode())) {
			return ProductApiCode.PRODUCT_NOT_EXIST;
		} else if ("901".equals(shopcartReq.getErrorCode())) {
			return ShoppingCartApiCode.SHOPPING_CART_FULL;
		} else if ("902".equals(shopcartReq.getErrorCode())) {
			return ShoppingCartApiCode.SKU_NUM_MAX_LIMIT;
		}
		return shopcartReq.getErrorCode();
	}

	@Override
	public Map<String, Object> list(String ticketId, Long activityId) {
		LOGGER.info("获取认筹券号：{}的购物车信息.", ticketId);
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		ShoppingCartQueryRequest req = new ShoppingCartQueryRequest();
		req.setTicketId(ticketId);
		req.setActivityId(activityId);
		ShoppingCartQueryResponse result = shoppingCartFacade.queryShoppingCarts(req);
		if (StringUtil.isBlank(result.getErrorCode())) {
			ShoppingCartInfo cartInfo = result.getCartInfo();
			LOGGER.info("购物车基本信息：{}", FastJSONHelper.serialize(cartInfo));
			resultMap.put(Constants.RESPONSE_CONTENT, result.getCartInfo());
		}
		if (BaseApiCode.OPERATE_SYSTEM_FAIL.equals(result.getErrorCode())) {
			resultMap.put(Constants.RESPONSE_NAME, result.getErrorCode());
		}
		return resultMap;
	}

}
