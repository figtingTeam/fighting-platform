package com.midea.cmo2o.wx.impl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midea.cmo2o.wx.impl.core.fieldpack.annotions.PackTarget;
import com.midea.cmo2o.wx.impl.dao.TOrderMainMapper;
import com.midea.cmo2o.wx.impl.dto.response.OrderInfoRes;
import com.midea.cmo2o.wx.impl.service.IOrderService;

/**
 * 类OrderServiceImpl.java的实现描述：订单接口实现类
 * 
 * @author huanghf 2015年12月28日 下午1:37:36
 * @email haifeng1.huang@midea.com
 */

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private TOrderMainMapper tOrderMainMapper;

	@PackTarget
	@Override
	public List<OrderInfoRes> getOrdersByTicketId(String ticketId) {
		// 联合三张表查询并封装订单数据
		List<OrderInfoRes> orders = tOrderMainMapper.getOrdersByTicketId(ticketId);
		return orders;
	}

}
