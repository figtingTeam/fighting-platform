package com.dongyuan.figting.service;

import java.util.List;

import com.dongyuan.figting.dto.response.OrderInfoRes;

/**
 * 类IOrderService.java的实现描述：订单接口
 * 
 * @author huanghf 2015年12月24日 下午5:34:46
 * @email haifeng1.huang@midea.com
 */
public interface IOrderService {

	/**
	 * 根据认筹券号获取订单列表
	 * @param ticketId
	 * @return
	 */
	List<OrderInfoRes> getOrdersByTicketId(String ticketId);
	
}
