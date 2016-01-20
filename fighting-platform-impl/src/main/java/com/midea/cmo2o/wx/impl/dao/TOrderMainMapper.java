package com.midea.cmo2o.wx.impl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.midea.cmo2o.wx.impl.dao.annotations.IRepository;
import com.midea.cmo2o.wx.impl.dto.response.OrderInfoRes;
import com.midea.cmo2o.wx.impl.entity.TOrderMain;
import com.midea.cmo2o.wx.impl.entity.TOrderMainExample;

@IRepository
public interface TOrderMainMapper {
	int countByExample(TOrderMainExample example);

	int deleteByExample(TOrderMainExample example);

	int deleteByPrimaryKey(String orderId);

	int insert(TOrderMain record);

	int insertSelective(TOrderMain record);

	List<TOrderMain> selectByExample(TOrderMainExample example);

	TOrderMain selectByPrimaryKey(String orderId);

	int updateByExampleSelective(@Param("record") TOrderMain record,
			@Param("example") TOrderMainExample example);

	int updateByExample(@Param("record") TOrderMain record,
			@Param("example") TOrderMainExample example);

	int updateByPrimaryKeySelective(TOrderMain record);

	int updateByPrimaryKey(TOrderMain record);
	
	List<OrderInfoRes> getOrdersByTicketId(String ticketId);
}