package com.dongyuan.figting.service;

import java.util.Map;

import com.dongyuan.figting.dto.request.CartAddRequest;
import com.dongyuan.figting.dto.request.CartDeleteRequest;
import com.dongyuan.figting.dto.request.CartModifyRequest;

/**
 * 类IShoppingCartService.java的实现描述：购物车接口
 * 
 * @author huanghf 2015年12月24日 下午5:34:46
 * @email haifeng1.huang@midea.com
 */
public interface IShoppingCartService {

	Map<String, Object> list(String ticketId, Long activityId);

	String addItem(CartAddRequest cartAddRequest);

	String modifyCount(CartModifyRequest cartModifyRequest);

	String deleteItem(CartDeleteRequest cartDeleteRequest);
}