package com.dongyuan.figting.impl.dao;

import java.util.List;

import com.dongyuan.figting.impl.dto.response.OrderInfoRes;
import com.dongyuan.figting.impl.entity.TOrderMain;
import com.dongyuan.figting.impl.entity.TOrderMainExample;
import org.apache.ibatis.annotations.Param;

import com.dongyuan.figting.impl.dao.annotations.IRepository;

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