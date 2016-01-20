package com.midea.cmo2o.wx.impl.service;

import java.util.List;

import com.midea.cmo2o.wx.impl.dto.request.TicketActivateRequest;
import com.midea.cmo2o.wx.impl.dto.request.TicketBindRequest;
import com.midea.cmo2o.wx.impl.dto.response.ActivityInfoRes;
import com.midea.cmo2o.wx.impl.dto.response.TicketAddrInfoRes;
import com.midea.cmo2o.wx.impl.dto.response.TicketBasicInfoRes;

/**
 * 类ITicketService.java的实现描述：认筹券接口
 * 
 * @author huanghf 2015年12月24日 下午5:34:46
 * @email haifeng1.huang@midea.com
 */
public interface ITicketService {

	/**
	 * 根据openid获取认筹券列表
	 * @param openid
	 * @return
	 */
	List<TicketBasicInfoRes> getTicketsByOpenid(String openid);
	
	/**
	 * 校验认筹券
	 * @param openid
	 * @param ticketId
	 * @return 返回结果码
	 */
	String checkTicket(String openid, String ticketId);
	
	/**
	 * 根据认筹券号获取认筹券信息
	 * @param ticketId
	 * @return
	 */
	TicketBasicInfoRes getTicketById(String ticketId);
	
	/**
	 * 绑定openid
	 */
	String bindOpenid(TicketBindRequest request);
	
	/**
	 * 激活认筹券
	 * @param ticketActivateRequest
	 * @return
	 */
	String activate(TicketActivateRequest request);
	
	/**
	 * 活动券号对应活动首页，认筹券信息、对应的活动信息、二维码
	 */
	ActivityInfoRes getActivityByTicketId(String ticketId, Long activityId);
	
	/*
	 * 企业号输入认筹券，根据认筹券获得相应u_ticket、u_address表中信息
	 */
	TicketAddrInfoRes getTicket(String ticketId, String mobile, Long activityId);
	
}
